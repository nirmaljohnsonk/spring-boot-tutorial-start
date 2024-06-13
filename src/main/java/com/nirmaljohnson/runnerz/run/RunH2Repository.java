package com.nirmaljohnson.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunH2Repository {
    JdbcClient jdbcClient;

    public RunH2Repository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public void save(Run run){
        jdbcClient.sql("INSERT INTO RUNS (ID, TITLE, STARTED_ON, COMPLETED_ON, MILES, LOCATION)\n" +
                "VALUES (?,?,?,?,?,?)")
                .params(List.of(run.id(),run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
                .update();
    }

    public void update(int id, Run run){
        jdbcClient.sql("UPDATE RUNS SET TITLE=?, STARTED_ON=?, COMPLETED_ON=?, MILES=?, LOCATION=? WHERE ID=?")
                .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(),id))
                .update();
    }

    public Optional<Run> findById(int id){
        return jdbcClient.sql("SELECT * FROM RUNS WHERE ID=:id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public List<Run> findAll(){
        return jdbcClient.sql("select * from RUNS")
                .query(Run.class)
                .list();
    }

    public void delete(int id){
        jdbcClient.sql("DELETE FROM RUNS WHERE ID=?")
                .params(List.of(id))
                .update();
    }
}
