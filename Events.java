import java.util.*;
import java.io.*;
public class Events{
    private ArrayList<String> events;
    private ArrayList<Double> changeRate;

    public void eventMaker(String filename){
        try{
            Scanner fileScan=new Scanner(new File(filename));
            int i=0;
            while(fileScan.hasNextLine()){
                String line=fileScan.nextLine();
                String[] inputs=line.split(",");
                Events(inputs[0],Double.parseDouble(inputs[1]));
            }
        }catch(FileNotFoundException skill){
            System.out.println("File not found. try again");
        }
    }

    public void Events (String EventText, double changeRates){
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
    public void EventHappens(nationState nation){
        Random rand=new Random();
        int happening=rand.nextInt(events.size());
        System.out.println(events.get(happening));
        nation.setGEGM(changeRate.get(happening)*nation.getGEGM());
    }
}
