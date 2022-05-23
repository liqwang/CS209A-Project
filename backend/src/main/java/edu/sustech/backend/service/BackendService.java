package edu.sustech.backend.service;

import edu.sustech.backend.entities.DependencyData;
import edu.sustech.search.engine.github.models.issue.IPRResult;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public interface BackendService {
    void updateLocalData() throws IOException, InterruptedException;

    @Async
    void readLocalData() throws IOException;

    IPRResult readLocalLog4jIPRData() throws IOException;

    void updateLocalLog4jIPRData() throws IOException, InterruptedException;

    DependencyData getDependencyData();

    String getDependencyUsageWithLocation();

    String getTopUsedDependencies(@Nullable String group, @Nullable Integer year, int dataCount);

    String getTopUsedVersions(@Nullable String group, @Nullable String artifact, @Nullable Integer year);

    String getAvailableGroupSelections();

    String getAvailableDependencySelections();

    DependencyData readLocalDependencyData() throws IOException;

    void updateLocalDependencyData() throws IOException, InterruptedException;

    void updateLocalDependencyData(int count) throws IOException, InterruptedException;

    void testWrite() throws FileNotFoundException;
}
