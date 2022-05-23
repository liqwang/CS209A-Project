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
            String groupId = parseXmlContents(s, "groupId").get(0); // get(0) will not count those <groupID> in <exclusion>
            String artifactName = parseXmlContents(s, "artifactId").get(0); // get(0) will not count those <artifactID> in <exclusion>
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

        Matcher matcherL = Pattern.compile("<" + label + ">").matcher(xmlSource);
        Matcher matcherR = Pattern.compile("</" + label + ">").matcher(xmlSource);

        //Todo: matcher.find() may cause StackOverflow Error due to its internal error
        while (matcherL.find()) {
            if (matcherR.find() && matcherL.end() < matcherR.start()) {
                result.add(xmlSource.substring(matcherL.end(), matcherR.start()));
            }else{
                break;
            }
        }
        return result;
    }
}
