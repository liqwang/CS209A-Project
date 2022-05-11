package edu.sustech.backend.controller;

import edu.sustech.backend.dao.ArtifactDao;
import edu.sustech.backend.dao.GroupDao;
import edu.sustech.backend.dao.VersionDao;
import edu.sustech.backend.dto.Artifact;
import edu.sustech.backend.dto.Group;
import edu.sustech.backend.dto.Version;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/import")
public class DataImportController {
    private static final String COOKIE = "_octo=GH1.1.1761678153.1640330188; _device_id=05fbc1ab0bf74d12c1c54c75646df56e; user_session=z140PO7SQ_1YRyx5LJQl7jUcUeQWw9rfjr1kf-DgogZ41Gu0; __Host-user_session_same_site=z140PO7SQ_1YRyx5LJQl7jUcUeQWw9rfjr1kf-DgogZ41Gu0; logged_in=yes; dotcom_user=QuanQuan-CHO; color_mode={\"color_mode\":\"auto\",\"light_theme\":{\"name\":\"light\",\"color_mode\":\"light\"},\"dark_theme\":{\"name\":\"dark\",\"color_mode\":\"dark\"}}; tz=Asia/Shanghai; has_recent_activity=1; _gh_sess=1fd5Js6eEjv2dikafIDcM+qoEXXQkqqOt0ZWlCNWFKZO3Va6HiVid1f5qCS/0+LB3Ffu+8fpnRllQB9pGVhSdaQZ9WCR1xKvHuTU9Lw6BUi+oGCVTho6ou/SNGtVvaJQjawvN9Cvh96M5lvYZGbyBAaZzsOrRoXf2yid4isDNUXVhmwxdt2vB9u2CfgBPOyET3D6OPQ8HdDMpV2T1dFSe3/JnKnLa+ph--tCpsE+P5a6GfWoqZ--pA9QfYsrwdvZtxbZHQko/w==";
    private static final int PAGES = 100;

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private ArtifactDao artifactDao;
    @Autowired
    private VersionDao versionDao;

    @RequestMapping("/pom")
    public void importData() throws IOException {
        for (int page = 1; page <= PAGES; page++) {
            String url = "https://github.com/search?l=Maven+POM&p=" + page + "&q=filename%3Apom.xml&type=Code";
            System.out.println("\n正在查询第" + page + "页...");
            Document document = Jsoup.parse(getHtml(url));
            Element codeList = document.select("#code_search_results > div.code-list").get(0);
            System.out.println("第" + page + "页共有" + codeList.children().size() + "个pom.xml文件");
            for (int i = 1; i <= codeList.children().size(); i++) {
                String href = codeList.child(i - 1).select("div > p > a").attr("href");
                String pomUrl = "https://raw.githubusercontent.com" + href.replace("/blob", "");
                System.out.println("正在查询第" + i + "个:" + pomUrl + "...");


                //Using repos API, parse the json file returned, locate the "created_at" entry, then parse the date.
                String repositoryUrl = "https://api.github.com/repos" + href.substring(0, href.indexOf("/blob"));
                String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String htmlContent = getHtml(repositoryUrl);
                Date creationDate = simpleDateFormat.parse(htmlContent, new ParsePosition(htmlContent.indexOf("\"created_at\": \"") + "\"created_at\": \"".length()));

                try {
                    String pom = getHtml(pomUrl);
                    System.out.println("已获得" + pomUrl);
                    for (String dependency : getContents(pom, "dependency")) {
                        String groupName = getContents(dependency, "groupId").get(0);
                        String artifactName = getContents(dependency, "artifactId").get(0);
                        List<String> versionRes = getContents(dependency, "version");
                        String versionName = "NULL";
                        if (!versionRes.isEmpty())
                            versionName = versionRes.get(0);

                        Group group = groupDao.get(groupName);
                        if (group == null) {
                            int groupId = groupDao.insert(groupName);
                            int artifactId = artifactDao.insert(artifactName, groupId);
                            versionDao.insert(versionName, artifactId);
                        } else {
                            Artifact artifact = artifactDao.get(artifactName, group.getId());
                            if (artifact == null) {
                                int artifactId = artifactDao.insert(artifactName, group.getId());
                                versionDao.insert(versionName, artifactId);
                            } else {
                                Version version = versionDao.get(versionName, artifact.getId());
                                if (version == null) {
                                    versionDao.insert(versionName, artifact.getId());
                                } else {
                                    versionDao.increment(version.getId(), version.getCount() + 1);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("查询超时");
                }
            }
        }
    }

    private static String getHtml(String url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("cookie", COOKIE);

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);
        br.close();
        return sb.toString();
    }

    private static List<String> getContents(String source, String label) {
        Matcher matcher = Pattern.compile("<" + label + ">(.|\n|\r)+?</" + label + ">").matcher(source);
        ArrayList<String> contents = new ArrayList<>();
        while (matcher.find())
            contents.add(matcher.group().replaceAll("</?" + label + ">", ""));
        return contents;
    }

}
