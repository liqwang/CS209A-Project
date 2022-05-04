package edu.sustech.backend.dao;

import edu.sustech.backend.dto.Group;

public interface GroupDao {
	int insert(String name);

	Group get(String name);
}
