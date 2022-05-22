package edu.sustech.backend.controller.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.sustech.backend.service.BackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

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

    @Autowired
    private BackendService backendService;

    public UpdateStatus status = UpdateStatus.NOT_INITIATED;

    @CrossOrigin
    @RequestMapping("data/top-used-dependencies")
    public ResponseEntity<String> getTopUsedDependencies(
            @RequestParam(value = "group", required = false) String group,
            @RequestParam(value = "date", required = false) Date date,
            @RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
        String s = backendService.getTopUsedDependencies(group, date, count);
        return ResponseEntity.ok(s);
    }

    @CrossOrigin
    @RequestMapping("data/top-used-version")
    public ResponseEntity<String> getTopUsedVersion(
            @RequestParam("group") String group,
            @RequestParam("arifact") String artifact,
            @RequestParam(value = "year", required = false) Integer year) {
        String s = backendService.getTopUsedVersions(group, artifact, year);
        return ResponseEntity.ok(s);
    }

    @CrossOrigin
    @RequestMapping("groups")
    public String getGroups(){
        return backendService.getAvailableGroupSelections();
    }

    @CrossOrigin
    @RequestMapping("local/update-all")
    public ResponseEntity<String> update() throws IOException, InterruptedException {
        if (status == UpdateStatus.NOT_INITIATED) {
            status = UpdateStatus.PROGRESS;
            updateData();
        } else {
            return ResponseEntity.badRequest().body("Failed. The update is initiated: " + status);
        }
        return ResponseEntity.ok("OK. Update status: " + status);
    }

    @CrossOrigin
    @RequestMapping("local/update-status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("OK. Update status: " + status);
    }

    @Async
    public void updateData() throws IOException, InterruptedException {
        backendService.updateLocalData();
        status = UpdateStatus.SUCCESS;
    }

    @CrossOrigin
    @RequestMapping("data/test/dependencyUpdate")
    public ResponseEntity<String> getDependencyUpdate(@RequestParam(value = "count", defaultValue = "10") Integer count) {
        try {
            backendService.updateLocalDependencyData(count);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("OK. Updated test sample data.");
    }

    @RequestMapping("data/reloadLocalData")
    public ResponseEntity<String> reloadLocalData() {
        try {
            backendService.readLocalData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("OK. Reloaded data.");
    }

    /**
     * Used for verifying the response received by Axios
     *
     * @return Response Body in <code>String</code>
     */
    @CrossOrigin
    @RequestMapping("data/sample")
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
