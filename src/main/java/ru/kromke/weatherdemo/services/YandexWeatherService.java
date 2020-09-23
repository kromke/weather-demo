package ru.kromke.weatherdemo.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.kromke.weatherdemo.model.Weather;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YandexWeatherService implements WeatherService{

    @Value("${app.city-name}")
    private String cityName;

    @SneakyThrows
    @Override
    public List<Weather> gWeather() {
        Document doc = Jsoup.connect(String.format("https://yandex.ru/pogoda/%s", cityName)).get();
        Element temperature = doc.selectFirst(".temp__value");
        return List.of(new Weather("YandexWeather", cityName, temperature.text()));
    }
}
