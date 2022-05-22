package edu.sustech.backend;

import edu.sustech.backend.service.BackendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private BackendService backendService;

    @Test
    void contextLoads() {
    }

    @Test
    void dataTestQ1() {
        try {
            backendService.updateLocalDependencyData();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void writePermissionTestQ2() throws FileNotFoundException {
        backendService.testWrite();
    }

}
