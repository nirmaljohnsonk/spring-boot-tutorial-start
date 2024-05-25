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

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @RequestMapping(path = "/api/v1/ping", method = RequestMethod.GET)
    private String ping(){
        return "Application started...";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    private String createRun(@Valid @RequestBody Run run){
        runRepository.save(run);
        return "Run created";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    private String updateRun(@PathVariable Integer id, @RequestBody Run run){
        runRepository.update(id, run);
        return "Run created";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    private Run getRunById(@PathVariable Integer id){
        return runRepository.findById(id)
                .orElseThrow(RunNotFoundException::new);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    private List<Run> getRuns(){
        return runRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    private String deleteRun(@PathVariable Integer id){
         runRepository.delete(id);
         return "Run deleted successfully";
    }

}
