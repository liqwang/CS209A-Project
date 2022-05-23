package edu.sustech.search.engine.github.analyzer;

import edu.sustech.search.engine.github.models.Dependency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private static final Logger logger = LogManager.getLogger(Analyzer.class);

    public static List<Dependency> parseDependency(String rawPomString) {
        ArrayList<Dependency> result = new ArrayList<>();

        /**
         * Author: QuanQuan
         */
        List<String> dependencyList;
        try {
            dependencyList = parseXmlContents(rawPomString, "dependency");
        } catch (StackOverflowError e) {
            logger.error(e);
            logger.error("Internal parsing failure.");
            return result;
        }

        for (String s : dependencyList) {
            String groupId = parseXmlContents(s, "groupId").get(0); //因为是get(0)所以不会统计exclusions里的group
            String artifactName = parseXmlContents(s, "artifactId").get(0); //因为是get(0)所以不会统计exclusions里的artifact
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
     * <br>
     * This method sometimes causes <code>StackOverflowError</code> because of the matcher.
     * I would have recommended a better way but let's now just discard these ideas.
     *
     * @param xmlSource xml source file in String form
     * @param label     first-level label to extract content
     * @return <code>List</code> of contents (may contain nothing)
     * @author QuanQuan
     */
    private static List<String> parseXmlContents(String xmlSource, String label) {
        ArrayList<String> result = new ArrayList<>();

        Matcher matcher = Pattern.compile("<" + label + ">(.|\\n|\\r)+?</" + label + ">").matcher(xmlSource);
        while (matcher.find()) {//Todo: Bug出现在这一行，但我不知道为什么matcher.find()会StackOverFlow
            result.add(matcher.group().replaceAll("</?" + label + ">", ""));
        }
        return result;
    }
}
