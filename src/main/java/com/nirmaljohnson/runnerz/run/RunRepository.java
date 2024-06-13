package com.nirmaljohnson.runnerz.run;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RunRepository extends ListCrudRepository<Run, Integer> {

    List<Run> findAllByLocation(String location);
}
