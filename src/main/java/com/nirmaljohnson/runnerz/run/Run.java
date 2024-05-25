package com.nirmaljohnson.runnerz.run;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(

        Integer id,
        @NotBlank
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {
}
