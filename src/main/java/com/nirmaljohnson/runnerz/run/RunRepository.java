package com.nirmaljohnson.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    void save(Run run){
        runs.add(run);
    }

    public void update(Integer id, Run run) {
        Optional<Run> optionalRun = findById(id);
        optionalRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> id.equals(run.id())).findFirst();
    }

    List<Run> findAll(){
        return runs;
    }

    public void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "Wednesday Run",
                LocalDateTime.now(),
                LocalDateTime.now(),
                25,
                Location.INDOOR
        ));
        runs.add(new Run(2,
                "Thursday Run",
                LocalDateTime.now(),
                LocalDateTime.now(),
                25,
                Location.OUTDOOR
        ));
    }

}
