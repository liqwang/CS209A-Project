package edu.sustech.backend.service;

import edu.sustech.backend.entities.DependencyData;
import edu.sustech.backend.service.models.QueryItem;
import edu.sustech.search.engine.github.models.issue.IPRResult;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BackendService {
    void updateLocalData() throws IOException, InterruptedException;

    @Async
    void readLocalData() throws IOException;

    IPRResult readLocalLog4jIPRData() throws IOException;

    void updateLocalLog4jIPRData() throws IOException, InterruptedException;

    DependencyData getDependencyData();

    String getDependencyUsageWithLocation();

    String getTopUsedDependencies(@Nullable String group, @Nullable Integer year, @Nullable Integer dataCount);

    String getTopUsedVersions(@Nullable String group, @Nullable String artifact, @Nullable Integer year, @Nullable Integer dataCount);

    String getAvailableGroupSelections();

    String getAvailableDependencySelections();

    DependencyData readLocalDependencyData() throws IOException;

    void resolveTransitiveDependency() throws IOException;

    Map<String, Integer> getSpringData();

    Map<String,Integer> getLombokData();

    Map<String, Integer> getLog4jData();

    Map<String,Integer> getMysqlData();

    void updateLocalDependencyData() throws IOException, InterruptedException;

    void updateLocalDependencyData(int count) throws IOException, InterruptedException;

    void readLocalQueryStatus();

    void testWrite() throws FileNotFoundException;

    Integer getSampledEntries();

    Integer getRequestCount();

    Integer getSampleSize();

    void appendNewQueryStatus(QueryItem item);

    void overwriteLastQueryStatus(QueryItem item);

    List<QueryItem> readQueryStatus();
}
