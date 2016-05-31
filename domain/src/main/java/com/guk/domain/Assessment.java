package com.guk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Assessment {
    @JsonProperty("access_log_enabled")
    private boolean accessLogEnabled;
    private long id;
    private String name;
    @JsonProperty("run_once")
    private boolean runOnce;
    private boolean snooze;
}
