import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        FileHandler fileH = new FileHandler();

        WeatherReport firstJan = new WeatherReport("1. Jan.",26,"warm");
        fileH.writeToFile(firstJan);

        WeatherReport secondJan = new WeatherReport("2. Jan",18,"rather warm");
        fileH.writeToFile(secondJan);

        WeatherReport thirdJan = new WeatherReport("3. Jan",22," warm");
        fileH.writeToFile(thirdJan);

        WeatherReport fourthJan = new WeatherReport("4. Jan",28,"Hot");
        fileH.writeToFile(fourthJan);

        WeatherReport fithJan = new WeatherReport("5. Jan",35,"pretty hot");
        fileH.writeToFile(fithJan);

        JSONArray wr = new JSONArray();

        JSONObject weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", firstJan.getDate());
        weatherReportJSON.put("temperature", firstJan.getTemperature());
        weatherReportJSON.put("summary", firstJan.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", secondJan.getDate());
        weatherReportJSON.put("temperature", secondJan.getTemperature());
        weatherReportJSON.put("summary", secondJan.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", thirdJan.getDate());
        weatherReportJSON.put("temperature", thirdJan.getTemperature());
        weatherReportJSON.put("summary", thirdJan.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", fourthJan.getDate());
        weatherReportJSON.put("temperature", fourthJan.getTemperature());
        weatherReportJSON.put("summary", fourthJan.getSummary());
        wr.add(weatherReportJSON);

        weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", fithJan.getDate());
        weatherReportJSON.put("temperature", fithJan.getTemperature());
        weatherReportJSON.put("summary", fithJan.getSummary());
        wr.add(weatherReportJSON);

        fileH.writeToFile(wr);
        List<WeatherReport> list = fileH.readArrayFromFile();
    }
}