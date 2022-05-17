package edu.sustech.backend.controller.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.sustech.backend.entities.DependencyData;
import edu.sustech.backend.entities.DependencyResult;
import edu.sustech.backend.service.BackendService;
import edu.sustech.search.engine.github.models.Dependency;
import edu.sustech.search.engine.github.models.Entry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RestController
@RequestMapping("api")
public class APIController {
    public enum UpdateStatus {
        PROGRESS("In Progress"), SUCCESS("Success"), FAILED("Failed"), NOT_INITIATED("Not initiated");

        String s;

        UpdateStatus(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    public UpdateStatus status = UpdateStatus.NOT_INITIATED;

    @CrossOrigin
    @RequestMapping("top_used_dependencies")
    public ResponseEntity<String> getTopUsedDependencies() {
        String s = BackendService.getTopUsedDependencies();
        try {
            PrintWriter pw = new PrintWriter("backend/data/a1.json");
            pw.write(s);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(s);
    }

    @CrossOrigin
    @RequestMapping("update_all")
    public ResponseEntity<String> update() throws IOException, InterruptedException {
        new Thread(() -> {
            if (status != UpdateStatus.NOT_INITIATED) {
                status = UpdateStatus.PROGRESS;
                try {
                    updateData();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return ResponseEntity.ok("OK. Update status: " + status);
    }

    @CrossOrigin
    @RequestMapping("update_status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("OK. Update status: " + status.toString());
    }

    public void updateData() throws IOException, InterruptedException {
        BackendService.updateLocalData();
        status = UpdateStatus.SUCCESS;
    }


    @CrossOrigin
    @RequestMapping("sample")
    @ResponseBody
    public String getSampleResponse() throws JsonProcessingException {
        ObjectMapper mpr = new ObjectMapper();
        ObjectNode data = mpr.createObjectNode();

        ObjectNode options = mpr.createObjectNode();
        ArrayNode series = mpr.createArrayNode();
        ObjectNode chart = mpr.createObjectNode();
        ObjectNode xaxis = mpr.createObjectNode();
        ArrayNode categories = mpr.createArrayNode();
        ObjectNode seriesItem = mpr.createObjectNode();
        chart.put("id", "vuechart-example");

        seriesItem.put("name", "series-xyz");
        ArrayNode dataNode = mpr.createArrayNode();
        for (int i = 2001; i <= 2022; i++) {
            categories.add(i);
            dataNode.add(i - 2000 + 30);
        }
        seriesItem.set("data", dataNode);
        xaxis.set("categories", categories);
        series.add(seriesItem);
        options.set("chart", chart);
        options.set("xaxis", xaxis);
        data.set("options", options);
        data.set("series", series);

        return mpr.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }
}