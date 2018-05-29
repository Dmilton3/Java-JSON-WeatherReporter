import java.text.DecimalFormat;

/**
 * Created by ASUS on 3/31/2016.
 */
public class ICAO {
    private String name;
    private long elevation;
    private String clouds;
    private String temperature;
    private double lat;
    private double lng;
    private String dTime;
    private long humidity;
    private String status;


    public ICAO(){
        name = "";
        elevation = 0;
        clouds = "";
        temperature = "";
        lat = 0;
        lng = 0;
        dTime = "";
        humidity = 0;
        status = null;
    }

    /*
       Sets object name
       @param String new Name
     */
    public void setName(String _name){

            this.name = _name;

    }

    /*
      @return name
     */
    public String getName(){
        return this.name;
    }

    /*
      Sets the elevation
      @param String elevation
     */
    public void setElevation(long _elevation){
        this.elevation = _elevation;
    }

    /*
      @return String elevation
     */
    public long getElevation(){
        return this.elevation;
    }

    /*
      @param String set cloud string
     */
    public void setClouds(String _clouds){
        this.clouds = _clouds;
    }

    /*
      @return String clouds
     */
    public String getClouds(){
        return this.clouds;
    }

    /*
      @param String temperature
     */
    public void setTemperature(String temp){
        this.temperature = temp;
    }

    /*
      returns if an error or not
     */
    public String getStatus(){
        return this.status;
    }

    /*
     @return String temperature
     */
    public String getTemperature(){
        return this.temperature;
    }

    /*
      @param String new Latitude
     */
    public void setLat(double _lat){
        this.lat = _lat;
    }

    /*
     @return String latitude
     */
    public double getLat(){
        return this.lat;
    }

    /*
      @param String set longitude
     */
    public void setLng(double _lng){
        this.lng = _lng;
    }

    /*
    @return String longitude
     */
    public double getLng(){
        return this.lng;
    }

    /*
      @param String new date and time
     */
    public void setdTime(String newTime){
        this.dTime = newTime;
    }

    /*
    @return String date and time
     */
    public String getdTime(){
        return this.dTime;
    }

    /*
    @param String new humidity
     */
    public void setHumidity(long hum){
        this.humidity = hum;
    }

    /*
      @return String humidity
     */
    public long getHumidity(){
        return this.humidity;
    }

    public void setStatus(String _status){
        this.status = _status;
    }

    public String toString(){
        String result = "";

        DecimalFormat df = new DecimalFormat("#.##");
        double tmpLat = Double.valueOf(df.format(this.lat));
        double tmpLng = Double.valueOf(df.format(this.lng));
        if(this.status == null) {
            result = this.name + " \nTemperature: " + this.temperature + " \nlatitude: " + tmpLat + " \nLongitude: "
                    + tmpLng + " \nDate and Time: " + this.dTime + " \nHumidity level: "
                    + this.humidity + " \nCloud cover: " + this.clouds + "\n";
        }
        else
        result = this.status;

        return result;
    }

}
