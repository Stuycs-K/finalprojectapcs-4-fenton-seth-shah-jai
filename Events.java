import java.util.*;
public class Events{
    private String EventText;
    private double changeGDP, changeGDPRate;


    public Events (double changeGDP, double changeGDPRate, String EventText){
        changeGDP=changeGDP;
        changeGDPRate=changeGDPRate;
        EventText=EventText;
    }

    public double changeGDP(){
        return changeGDP;
    }

    public double changeGDPRate(){
        return changeGDPRate;
    }

    public String EventText(){
        return EventText;
    }

    public void SomethingHappened(){
        System.out.println(EventText);
        
    }
}