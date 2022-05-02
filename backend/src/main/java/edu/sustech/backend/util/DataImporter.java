package edu.sustech.backend.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataImporter {
	private static final String COOKIE = "_octo=GH1.1.1761678153.1640330188; _device_id=05fbc1ab0bf74d12c1c54c75646df56e; user_session=z140PO7SQ_1YRyx5LJQl7jUcUeQWw9rfjr1kf-DgogZ41Gu0; __Host-user_session_same_site=z140PO7SQ_1YRyx5LJQl7jUcUeQWw9rfjr1kf-DgogZ41Gu0; logged_in=yes; dotcom_user=QuanQuan-CHO; color_mode={\"color_mode\":\"auto\",\"light_theme\":{\"name\":\"light\",\"color_mode\":\"light\"},\"dark_theme\":{\"name\":\"dark\",\"color_mode\":\"dark\"}}; tz=Asia/Shanghai; has_recent_activity=1; _gh_sess=1fd5Js6eEjv2dikafIDcM+qoEXXQkqqOt0ZWlCNWFKZO3Va6HiVid1f5qCS/0+LB3Ffu+8fpnRllQB9pGVhSdaQZ9WCR1xKvHuTU9Lw6BUi+oGCVTho6ou/SNGtVvaJQjawvN9Cvh96M5lvYZGbyBAaZzsOrRoXf2yid4isDNUXVhmwxdt2vB9u2CfgBPOyET3D6OPQ8HdDMpV2T1dFSe3/JnKnLa+ph--tCpsE+P5a6GfWoqZ--pA9QfYsrwdvZtxbZHQko/w==";
	private static final int PAGES=100;
	public static void main(String[] args) throws IOException {
		for (int page = 1; page <= PAGES; page++) {
			String url = "https://github.com/search?l=Maven+POM&p="+page+"&q=filename%3Apom.xml&type=Code";
			System.out.println("\n正在查询第"+page+"页...");
			Document document = Jsoup.parse(getHtml(url));
			Element codeList = document.select("#code_search_results > div.code-list").get(0);
			System.out.println("第"+page+"页共有"+codeList.children().size()+"个pom.xml文件");
			for (int i=1;i<=codeList.children().size();i++) {
				String href = codeList.child(i-1).select("div > p > a").attr("href");
				String pomUrl = "https://raw.githubusercontent.com" + href.replace("/blob", "");
				System.out.println("正在查询第"+i+"个:"+pomUrl+"...");
				try {
					String pom = getHtml(pomUrl);
					System.out.println("已获得" + pomUrl);
					for (String dependency : getContents(pom, "dependency")) {
						String group = getContents(dependency, "groupId").get(0);
						String artifact = getContents(dependency, "artifactId").get(0);
						List<String> versionRes = getContents(dependency, "version");
						String version="NULL";
						if(!versionRes.isEmpty())
							version = versionRes.get(0);
						
					}
				}catch (IOException e){
					System.out.println("查询超时");
				}
			}
		}
	}

	private static String getHtml(String url) throws IOException {
		HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("cookie",COOKIE);

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		while((line=br.readLine())!=null)
			sb.append(line);
		br.close();
		return sb.toString();
	}

	private static List<String> getContents(String source, String label){
		Matcher matcher = Pattern.compile("<" + label + ">(.|\n|\r)+?</" + label + ">").matcher(source);
		ArrayList<String> contents = new ArrayList<>();
		while(matcher.find())
			contents.add(matcher.group().replaceAll("</?" + label + ">",""));
		return contents;
	}
}
