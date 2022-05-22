package edu.sustech.engine.github;

import edu.sustech.backend.service.BackendService;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class LocalTest {
    BackendService backendService = new BackendService();

    @Test
    void getLocalData(){
        try {
            backendService.updateLocalData();
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
            backendService.updateLocalDependencyData(2);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testReadLocalDependencyData(){
        try{
            backendService.readLocalDependencyData();
            System.out.println(backendService.getDependencyData().getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testWrite() throws FileNotFoundException {
        backendService.testWrite();
    }

}
