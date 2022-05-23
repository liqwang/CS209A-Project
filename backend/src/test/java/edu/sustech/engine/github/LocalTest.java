package edu.sustech.engine.github;

import edu.sustech.backend.service.BackendServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class LocalTest {
    @Autowired
    private BackendServiceImpl backendServiceImpl;

    @Test
    void getLocalData(){
        try {
            backendServiceImpl.updateLocalData();
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
            backendServiceImpl.updateLocalDependencyData(2);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testReadLocalDependencyData(){
        try{
            backendServiceImpl.readLocalDependencyData();
            System.out.println(backendServiceImpl.getDependencyData().getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testWrite() throws FileNotFoundException {
        backendServiceImpl.testWrite();
    }

}
