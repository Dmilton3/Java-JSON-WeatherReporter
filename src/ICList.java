import java.util.ArrayList;
/**
 * Created by ASUS on 3/31/2016.
 */
public class ICList {
    private ArrayList<ICAO> list;

    public ICList(){
        list = new ArrayList<ICAO>();
    }

    public void addIC(ICAO icao){
        this.list.add(icao);
    }

    public ICAO getICAO(int index){
        return this.list.get(index);
    }

    /*
      @
     */
    public String toString(){
        String result = "";
        for(ICAO icao: list){
            result += icao.toString() + "\n";
        }

        return result;
    }

    /*
      Calculates min Temp
      @retrun min temp
     */
    public String minTemp(){
        String min = "";

            min = this.list.get(0).getTemperature();

        int pos = 1;
        String test = "";
        while(pos < list.size()){

            test = this.list.get(pos).getTemperature();

                if(Character.getNumericValue(min.charAt(0)) > Character.getNumericValue(test.charAt(0))){
                    min = test;
                }
                else if(Character.getNumericValue(min.charAt(0)) == Character.getNumericValue(test.charAt(0))){
                    if(Character.getNumericValue(min.charAt(1)) != '.' &&  Character.getNumericValue(test.charAt(1)) != '.') {
                        if (Character.getNumericValue(min.charAt(1)) > Character.getNumericValue(test.charAt(1))) {
                            min = test;
                        }
                    }
                    else if(Character.getNumericValue(test.charAt(1)) == '.'){
                        min = test;
                    }
                }

            pos++;

            while(pos < list.size() && this.list.get(pos).getStatus() != null){
                pos++;
            }


        }

        return min;
    }

    /*
      Calculates max temp in the list
      @return String max temp
     */
    public String maxTemp(){
        String max = "";

        max = this.list.get(0).getTemperature();

        int pos = 1;
        String test = list.get(1).getTemperature();
        while(pos < list.size()){
            test = this.list.get(pos).getTemperature();

            if(Character.getNumericValue(max.charAt(0)) < Character.getNumericValue(test.charAt(0))){
                max = test;
            }
            else if(Character.getNumericValue(max.charAt(0)) == Character.getNumericValue(test.charAt(0))){
                if(Character.getNumericValue(max.charAt(1)) != '.' &&  Character.getNumericValue(test.charAt(1)) != '.') {
                    if (Character.getNumericValue(max.charAt(1)) < Character.getNumericValue(test.charAt(1))) {
                        max = test;
                    }
                }
                else if(Character.getNumericValue(test.charAt(1)) == '.'){
                    max = test;
                }
            }

            pos++;

            while(pos < list.size() && this.list.get(pos).getStatus() != null){
                pos++;
            }


        }

        return max;
    }
}
