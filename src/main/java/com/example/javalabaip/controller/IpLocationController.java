package com.example.javalabaip.controller;

import com.example.javalabaip.dto.LocationResponseDto;
import com.example.javalabaip.service.IpLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpLocationController {

    private final IpLocationService ipLocationService;

    @Autowired
    public IpLocationController(IpLocationService ipLocationService) {
        this.ipLocationService = ipLocationService;
    }

    @GetMapping("/api/location")
    public ResponseEntity<LocationResponseDto> getLocation(@RequestParam("ip") String ipAddress) {
        LocationResponseDto response = ipLocationService.getLocationByIp(ipAddress);
        return ResponseEntity.ok(response);
    }
}