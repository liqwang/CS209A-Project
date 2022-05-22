package edu.sustech.engine.github;

import edu.sustech.backend.service.BackendService;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class LocalTest {
    @Test
    void getLocalData(){
        try {
            BackendService.updateLocalData();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testDependencyDataIO(){
        testUpdateLocalDependencyData();
        testReadLocalDependencyData();
    }

    @Test
    void testUpdateLocalDependencyData(){
        try {
            BackendService.updateLocalDependencyData(2);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testReadLocalDependencyData(){
        try{
            BackendService.readLocalDependencyData();
            System.out.println(BackendService.getDependencyData().getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testWrite() throws FileNotFoundException {
        BackendService.testWrite();
    }

}
