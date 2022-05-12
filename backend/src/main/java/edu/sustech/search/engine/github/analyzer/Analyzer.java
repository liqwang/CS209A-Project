package edu.sustech.search.engine.github.analyzer;

import edu.sustech.search.engine.github.analyzer.models.Dependency;
import edu.sustech.search.engine.github.models.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

    public static List<Dependency> parseDependency(String rawPomString) {
        ArrayList<Dependency> result = new ArrayList<>();

        /**
         * Author: QuanQuan
         */
        List<String> dependency_list = parseXmlContents(rawPomString, "dependency");
        for (String s : dependency_list) {
            String groupId = parseXmlContents(s, "groupId").get(0);
            String artifactName = parseXmlContents(s, "artifactId").get(0);
            List<String> versions = parseXmlContents(s, "version");

            String version = null;
            if (versions.size() != 0) {
                version = versions.get(0);
            }

            Dependency dependency = new Dependency(groupId, artifactName, version);
            if (!result.contains(dependency)) {
                result.add(dependency);
            }
        }
        return result;
    }

    /**
     * Parse the given content in the xml file
     *
     * @param xmlSource xml source file in String form
     * @param label     first-level label to extract content
     * @return <code>List</code> of contents (may contain nothing)
     * @author QuanQuan
     */
    private static List<String> parseXmlContents(String xmlSource, String label) {
        ArrayList<String> result = new ArrayList<>();

        Matcher matcher = Pattern.compile("<" + label + ">(.|\n|\r)+?</" + label + ">").matcher(xmlSource);
        while (matcher.find()) {
            result.add(matcher.group().replaceAll("</?" + label + ">", ""));
        }
        return result;
    }
}
