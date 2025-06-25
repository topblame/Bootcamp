package kr.OpenAi;

import com.fasterxml.jackson.databind.JsonNode;

public class Weather {
	public static void main(String[] args) {
		try {
			String city = "Seoul";
			JsonNode weatherData = WeatherApp.getWeather(city);
			String weatherResponse = OpenAIApp.generateWeatherResponse(weatherData);
			
			String[] lines = weatherResponse.split("\\. ");
			for(String line:lines) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
