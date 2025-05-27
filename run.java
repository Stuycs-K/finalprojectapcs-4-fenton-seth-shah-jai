import java.util.*;
public class run{
  private String userIn;
  private nationState nation;
  nationState Germany=new nationState(0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0);


  public GrabUserInput(){
    Scanner read=new Scanner(System.in);
    System.out.println("PLACEHOLDER FOR INPUT");
    userIn=read.nextLine();
  }
  public void ModifyNations(){
    
  }
  public boolean initializeNation(){
    nation=Germany;
    //Use initializeNation to get code when we integrate other stuff in, use userIn for that
    return false;
  }
  public void GrabConditions(){
    System.out.println("Tax Rev: "+ nation.getTaxRevenue()+"\nConsumerSpending: "
      +nation.getConsumerSpending()+"\nGDPGrowthRate: "+nation.getGDPGrowthRate()+
      "\nInflation & Debt: "+ nation.getinflationRate()+" & "+nation.getNationalDebt()
      +"\nJoy: "+nation.getJoy());

  }


  public void run(){
      GrabUserInput();
      initializeNation();
      while(nation.getJoy()>0){
        GrabConditions();
        System.out.println("Your Move");
        GrabUserInput();
        ModifyNations();
      }
  }
  public static void main(String[] args) {
    run();
  }
    //Take the function for calculateGDPgrowth and use use userinputs
}
