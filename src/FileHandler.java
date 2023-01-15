        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;
        import org.json.simple.parser.ParseException;

        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class FileHandler {
    private WeatherReport weatherReport;
    public void writeToFile(WeatherReport weatherReport){
        JSONObject weatherReportJSON = new JSONObject();
        weatherReportJSON.put("date", weatherReport.getDate());
        weatherReportJSON.put("temperature", weatherReport.getTemperature());
        weatherReportJSON.put("summary", weatherReport.getSummary());

        try(FileWriter file = new FileWriter("weatherReport.json")){
            file.write(weatherReportJSON.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeToFile(JSONArray weatherReports){
        try(FileWriter file = new FileWriter("weatherReports.json")){
            file.write(weatherReports.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public WeatherReport readFromFile(){
        WeatherReport weatherReport = null;

        try(FileReader reader = new FileReader("weatherReport.json")){
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);

            JSONObject weatherReportJSON = (JSONObject) obj;
            System.out.println(weatherReportJSON);

            System.out.println();
            System.out.println("Single Weather Report");

            weatherReport = parseJSON(weatherReportJSON);

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ParseException e){
            e.printStackTrace();
        }
        return weatherReport;
    }

    public List<WeatherReport> readArrayFromFile(){
        ArrayList<WeatherReport> weatherReports = new ArrayList<>();
        try(FileReader reader = new FileReader("weatherReports.json")){
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);

            JSONArray weatherReportsArrayJSON = (JSONArray) obj;
            System.out.println(weatherReportsArrayJSON);

            System.out.println();
            System.out.println("All Weather Reports");

            weatherReportsArrayJSON.forEach(weatherReportJSON -> {
                System.out.println();
                WeatherReport weatherReport = parseJSON((JSONObject) weatherReportJSON);
                weatherReports.add(weatherReport);
            });

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ParseException e){
            e.printStackTrace();
        }
        return weatherReports;
    }

    private WeatherReport parseJSON(JSONObject weatherReportJSON) {
        String date = (String) weatherReportJSON.get("date");
        System.out.println(date);

        int temperature = (int)(long) weatherReportJSON.get("temperature");
        System.out.println(temperature);

        String summary = (String) weatherReportJSON.get("summary");
        System.out.println(summary);

        WeatherReport weatherReport = new WeatherReport(date,temperature,summary);
        return weatherReport;
    }
}
