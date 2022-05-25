package edu.sustech.backend.controller;

import edu.sustech.backend.service.models.QueryItem;
import edu.sustech.backend.service.BackendService;
import edu.sustech.backend.service.models.ServerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/status")
public class BackendStatusController {
    @Autowired
    private BackendService backendService;


    @CrossOrigin
    @RequestMapping("query-status")
    public List<QueryItem> getQueryStatus() {
        return backendService.readQueryStatus();
    }


}
