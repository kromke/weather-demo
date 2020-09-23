package ru.kromke.weatherdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kromke.weatherdemo.model.Weather;
import ru.kromke.weatherdemo.services.WeatherService;

import java.util.List;

@RestController
public class WeatherRestController {

    private final WeatherService weatherService;

    public WeatherRestController(@Qualifier("yandexWeatherService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("api/weather")
    public List<Weather> getWeather() {return weatherService.gWeather();}
}
