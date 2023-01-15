import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class WeatherReport implements Serializable {
    private String date;
    private int temperature;
    private String summary;

    public WeatherReport(String date, int temperature, String summary){
        this.date = date;
        this.temperature = temperature;
        this.summary = summary;
    }

    public String getDate(){
        return date;
    }

    public int getTemperature(){
        return temperature;
    }

    public String getSummary(){
        return summary;
    }

    public String toString(){
        return date + " " + temperature + " " + summary;
    }
}