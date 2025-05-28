import java.util.*;
public class Events{
    private String EventText, changing;
    private double changeRate;

    public ArrayList<String> eventMaker(String filename){
        try{
            Scanner fileScan=new Scanner(new File(filename));
            while(fileScan.hasNextLine()){
                String line=fileScan.nextLine();
                String[] inputs=line.split(",");
                Events(inputs[0],(double)inputs[1],inputs[2]);
            }
        }catch(FileNotFoundException skill){
            System.out.println("File not found. try again");
        }
    }

    public Events (String EventText, double changeRate, String changing){
        changeGDP=changeGDP;
        changing=changing;
        EventText=EventText;
    }

    public String changing(){
        return changeGDP;
    }

    public String changeRate(){
        return changeRate;
    }

    public String EventText(){
        return EventText;
    }

    public void EventHappens(){

        System.out.println(EventText);
        changeDefaultGDPGrowthRate(changeRate);
        changeGDP(changeGDP);
    }
}
