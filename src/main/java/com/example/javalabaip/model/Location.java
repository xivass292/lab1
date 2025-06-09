package com.example.javalabaip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String ipAddress;
    private String city;
    private String country;
    private String continent;

}