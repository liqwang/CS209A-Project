package edu.sustech.search.engine.github.API.search;

public class ETag {
    public final String tag;

    public ETag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof ETag) == false) {
            return false;
        }
        return tag.equals(((ETag) o).tag);
    }
}
