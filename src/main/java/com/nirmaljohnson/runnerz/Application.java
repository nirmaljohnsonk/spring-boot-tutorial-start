package com.nirmaljohnson.runnerz;

import com.nirmaljohnson.runnerz.run.Location;
import com.nirmaljohnson.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner test(){
		return args->{
			Run run = new Run(1,"First Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(20),15, Location.INDOOR);
			log.info("Run : {}", run);
		};
	}

}
