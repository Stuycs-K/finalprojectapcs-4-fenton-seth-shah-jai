import java.util.*;
import java.io.*;
public class Events{
    private static ArrayList<String> events=new ArrayList<String>();
    private static ArrayList<Double> changeRate=new ArrayList<Double>();
    private static boolean hasMade=true;
    private static String current="Whatever man";
    
    public static void eventMaker(String[] fileText){
          //Note, I need a new filepath
          //System.out.println(finding.getAbsolutePath());
            for (int i = 0; i < fileText.length; i++) {
                String line=fileText[i];
                String[] inputs=line.split(",");
                int sign=Integer.parseInt(inputs[2]);
                Event(inputs[0],sign*Double.parseDouble(inputs[1]));
            }
       
    }

    public static void Event (String EventText, double changeRates){
        events.add(EventText);
        changeRate.add(changeRates);
    }
/*
    public String changing(){
        return changeGDP;
    }

    public String changeRate(){
        return changeRate;
    }

    public String EventText(){
        return EventText;
    }
*/

    public static void EventHappens(nationState nation){

        Random rand=new Random();
        //never generating the array list
        System.out.println(events);
        int happening=rand.nextInt(events.size());
        System.out.println(1);
        current=events.get(happening);
        System.out.println(events.get(happening));
        nation.setGEGM(changeRate.get(happening)*nation.getGEGM());
    }
    public static String getCurrent(){
      return current;
    } 
     
}
