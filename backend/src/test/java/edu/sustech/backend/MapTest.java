package edu.sustech.backend;

import edu.sustech.backend.service.BackendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapTest {
	@Autowired
	BackendService backendService;

	@Test
	void countryMapTest(){}
}
