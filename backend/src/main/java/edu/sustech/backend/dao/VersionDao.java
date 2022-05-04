package edu.sustech.backend.dao;

import edu.sustech.backend.dto.Version;
import org.apache.ibatis.annotations.Param;

public interface VersionDao {
	int insert(@Param("version") String version,@Param("artifactId") Integer artifactId);

	Version get(@Param("version") String version,@Param("artifactId") Integer artifactId);

	/**
	 * count++
	 */
	void increment(@Param("id") Integer id,@Param("newCount") Integer newCount);
}
