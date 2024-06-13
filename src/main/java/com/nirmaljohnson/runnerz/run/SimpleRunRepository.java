package com.nirmaljohnson.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SimpleRunRepository {
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

}
