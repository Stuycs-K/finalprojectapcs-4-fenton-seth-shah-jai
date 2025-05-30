import java.util.*;
import java.io.*;
public class Events{
    private static ArrayList<String> events;
    private static ArrayList<Double> changeRate;
    private static boolean hasMade=true;
    public Events{
        events=new ArrayList<String>();
        changeRate=new ArrayList<Double>();
    }
    public static void eventMaker(String filename){
        try{
            Scanner fileScan=new Scanner(new File(filename));
            int i=0;
            while(fileScan.hasNextLine()){
                String line=fileScan.nextLine();
                String[] inputs=line.split(",");
                Event(inputs[0],Double.parseDouble(inputs[1]));
            }
        }catch(FileNotFoundException skill){
            System.out.println("File not found. try again");
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
        if(hasMade){
          eventMaker("Events.txt");
          hasMade=false;
        }
        Random rand=new Random();
        int happening=rand.nextInt(events.size());
        System.out.println(events.get(happening));
        nation.setGEGM(changeRate.get(happening)*nation.getGEGM());
    }
}
