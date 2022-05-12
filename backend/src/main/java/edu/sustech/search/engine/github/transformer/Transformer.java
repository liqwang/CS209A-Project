package edu.sustech.search.engine.github.transformer;

import java.net.URI;
import java.net.URISyntaxException;

public class Transformer {
    public static URI transformToRawURI(URI htmlUrl){
        String s = htmlUrl.toString();
        s = s.replaceFirst("/blob","");
        s = s.replaceFirst("github.com", "raw.githubusercontent.com");
        try {
            return new URI(s);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
