package edu.sustech.backend.dao;

import edu.sustech.backend.dto.Artifact;
import org.apache.ibatis.annotations.Param;

public interface ArtifactDao {
	int insert(@Param("name") String name,@Param("groupId") Integer groupId);

	Artifact get(@Param("name") String name,@Param("groupId") Integer groupId);
}
