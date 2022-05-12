package edu.sustech.search.engine.github.analyzer.models;

public record Dependency(String groupId, String artifactId, String version) {

    @Override
    public String toString() {
        return "<groupId>" + groupId + "</groupId>" + "<artifactId>" + artifactId + "</artifactId>" + "<version>" + (version == null ? "<null>" : version) + "</version>";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Dependency d) {
            return groupId.equals(d.groupId) && artifactId.equals(d.artifactId)
                    && ((this.version == null && d.version == null) || ((this.version != null && d.version != null) && version.equals(d.version)));
        }
        return false;
    }
}
