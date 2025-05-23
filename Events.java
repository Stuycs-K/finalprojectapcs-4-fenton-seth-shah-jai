import java.util.*;
public class Events{
    private String EventText, changing;
    private double changeRate;


    public Events (String changing, double changeRate, String EventText){
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
