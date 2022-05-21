package edu.sustech.backend;

import edu.sustech.backend.service.BackendService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dataTestQ1() {
        try {
            BackendService.updateLocalDependencyData();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void functionalityTestQ1() {
        System.out.println(BackendService.getTopUsedDependencies());
    }

    @Test
    void writePermissionTestQ2() {
        BackendService.testWrite();
    }

}
