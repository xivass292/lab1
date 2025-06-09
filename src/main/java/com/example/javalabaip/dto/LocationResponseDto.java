package com.example.javalabaip.dto;

import lombok.Data;

@Data
public class LocationResponseDto {
    private String ipAddress;
    private String city;
    private String country;
    private String continent;
}