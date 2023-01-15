import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();

        WeatherReport eightDec = new WeatherReport("1. Jan.",26,"warm");
        fh.writeToFile(eightDec);

        WeatherReport nineDec = new WeatherReport("2. Jan",18,"rather warm");
        fh.writeToFile(nineDec);

        WeatherReport tenDec = new WeatherReport("3. Jan",22," warm");
        fh.writeToFile(tenDec);

        WeatherReport elevenDec = new WeatherReport("4. Jan",28,"Hot");
        fh.writeToFile(elevenDec);

        WeatherReport twelveDec = new WeatherReport("5. Jan",35,"pretty hot");
        fh.writeToFile(twelveDec);

        JSONArray wr = new JSONArray();

        JSONObject weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", eightDec.getDate());
        weatherReportJSON.put("temperature", eightDec.getTemperature());
        weatherReportJSON.put("summary", eightDec.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", nineDec.getDate());
        weatherReportJSON.put("temperature", nineDec.getTemperature());
        weatherReportJSON.put("summary", nineDec.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", tenDec.getDate());
        weatherReportJSON.put("temperature", tenDec.getTemperature());
        weatherReportJSON.put("summary", tenDec.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", elevenDec.getDate());
        weatherReportJSON.put("temperature", elevenDec.getTemperature());
        weatherReportJSON.put("summary", elevenDec.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", twelveDec.getDate());
        weatherReportJSON.put("temperature", twelveDec.getTemperature());
        weatherReportJSON.put("summary", twelveDec.getSummary());
        wr.add(weatherReportJSON);

        fh.writeToFile(wr);
        List<WeatherReport> list = fh.readArrayFromFile();
    }
}