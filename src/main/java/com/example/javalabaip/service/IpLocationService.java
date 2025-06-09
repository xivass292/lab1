package com.example.javalabaip.service;

import com.example.javalabaip.dto.LocationResponseDto;
import com.example.javalabaip.model.Location;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IpLocationService {

    private final RestTemplate restTemplate;

    public IpLocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LocationResponseDto getLocationByIp(String ipAddress) {
        try {
            String apiUrl = "http://ip-api.com/json/" + ipAddress;
            Location location = restTemplate.getForObject(apiUrl, Location.class);


            if (location == null || location.getCity() == null || location.getCountry() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неверный IP-адрес или ошибка API");
            }


            LocationResponseDto response = new LocationResponseDto();
            response.setIpAddress(ipAddress);
            response.setCity(location.getCity());
            response.setCountry(location.getCountry());

            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неверный IP-адрес: " + ipAddress, e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка получения данных о местоположении", e);
        }
    }
}