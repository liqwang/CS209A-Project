package edu.sustech.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.sustech.search.engine.github.API.GitHubAPI;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class APIController {
    GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");


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
