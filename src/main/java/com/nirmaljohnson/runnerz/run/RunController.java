package com.nirmaljohnson.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/runs")
public class RunController {

    private final RunRepository runRepository;
    private final RunH2Repository runH2Repository;

    public RunController(RunRepository runRepository, RunH2Repository runH2Repository) {
        this.runRepository = runRepository;
        this.runH2Repository = runH2Repository;
    }

    @RequestMapping(path = "/api/v1/ping", method = RequestMethod.GET)
    private String ping(){
        return "Application started...";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    private String createRun(@Valid @RequestBody Run run){
        runH2Repository.save(run);
        return "Run created";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    private String updateRun(@PathVariable Integer id, @RequestBody Run run){
        runH2Repository.update(id, run);
        return "Run created";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    private Run getRunById(@PathVariable Integer id){
        return runH2Repository.findById(id)
                .orElseThrow(RunNotFoundException::new);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    private List<Run> getRuns(){
        return runH2Repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    private String deleteRun(@PathVariable Integer id){
        runH2Repository.delete(id);
         return "Run deleted successfully";
    }

}
