import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.net.URL;
/**
 * Created by Dewey Milton on 3/31/2016.
 * JSONreader is used to get information off the geoname webSite and save the information
 * modified and used code from JSON simple example file
 */
public class JSONreader {

    private Scanner scan;
    private File file;
    private String stationCode;
    private String url1;
    private String url2;
    private String mainUrl;
    private ICAO newIcao;
    private int listCount;
    private ICList list;

    public JSONreader() throws Exception {

        file = new File("input.txt");
        scan = new Scanner(file);
        stationCode = "";
        url1 = "http://api.geonames.org/weatherIcaoJSON?ICAO=";
        url2 = "&formatted=true&username=dmilton3";

        list = new ICList();
        while(scan.hasNextLine()) {
            stationCode = scan.nextLine();

            mainUrl = "KBCB";

            String JSonString = readURL("http://api.geonames.org/weatherIcaoJSON?ICAO=" +  stationCode +  "&formatted=true&username=dmilton3");

            Object n = JSONValue.parse(JSonString);
            JSONObject x = (JSONObject) n;

            if(x != null) {
                JSONObject weatherData = (JSONObject) (x.get("weatherObservation"));
                if (weatherData != null) {
                    listCount++;
                    newIcao = new ICAO();
                    newIcao.setName((String) weatherData.get("stationName"));
                    newIcao.setElevation((long) weatherData.get("elevation"));
                    newIcao.setClouds((String) weatherData.get("clouds"));
                    newIcao.setTemperature((String) weatherData.get("temperature"));
                    newIcao.setLat((double) weatherData.get("lat"));
                    newIcao.setLng((double) weatherData.get("lng"));
                    newIcao.setdTime((String) weatherData.get("datetime"));
                    newIcao.setHumidity((long) weatherData.get("humidity"));

                    list.addIC(newIcao);

                } else {
                    newIcao = new ICAO();
                    newIcao.setStatus("\nno observation found\n");
                    list.addIC(newIcao);
                }

            }
            else{
                newIcao = new ICAO();
                newIcao.setStatus("\nno observation found\n");
                list.addIC(newIcao);
            }
        }

        String min = list.minTemp();
        String max = list.maxTemp();

        FileWriter writer = new FileWriter("output.txt");
        writer.write(list.toString());
        writer.write("Min Temp: " + min + "\n");
        writer.write("Max Temp: " + max + "\n");
        double dblMin = Double.parseDouble(min);
        double dblMax = Double.parseDouble(max);
        double average = dblMin + dblMax;
        average = average / listCount;
        DecimalFormat df = new DecimalFormat("##.##");
        writer.write("Average Temp: " + df.format(average));

        writer.close();
    }
        /**
         *
         * private helper method demonstrates how to read the contents of a URL as a String.
         *
         * This version improves upon version 1 through the use of IOUtils
         *
         * @param webservice provides the URL address of the web service to be accessed
         * @return String representation of the given web page or service
         * @throws java.net.MalformedURLException if the given url is poorly formed
         * @throws java.io.IOException if IOUtils encounters an IOException
         *
         **/

    private static String readURL(String webservice) throws java.net.MalformedURLException, java.io.IOException {
        // create a URL object from the given address
        URL service = new URL(webservice);

        // use IOUtils to access the URL and return a string
        String result = IOUtils.toString(service, "UTF-8");
        return result;
    }

}



