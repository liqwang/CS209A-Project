package edu.sustech.search.engine.github.transformer;

import java.net.URI;
import java.net.URISyntaxException;

public class Transformer {
    public static URI transformToRawURI(URI htmlUrl) {
        String s = htmlUrl.toString();
        s = s.replaceFirst("/blob", "");
        s = s.replaceFirst("github.com", "raw.githubusercontent.com");
        try {
            return new URI(preTransformURI(s));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String preTransformURI(String uri) {
        return uri.replaceAll("\\[", "%5B").replaceAll("\\]", "%5D");
    }
}
