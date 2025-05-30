import java.util.*;
public class run{
  private double[] userIn;
  private Double taxBrak, interestNum;
  private nationState nation=new nationState(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, 0.0, 0.0, 0.0, 0.0);
  nationState Germany=new nationState(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, 0.0, 0.0, 0.0, 0.0);
  Scanner read=new Scanner(System.in);



  public void GrabUserInput(){
    userIn=new double[6];
    for(int i=0;i<6;i++){
      userIn[i]=read.nextDouble();
    }
    read.nextLine();
  }
  public void GrabUserNum(){
    interestNum=read.nextDouble();
    read.nextLine();
  }
  public void GrabTaxBrak(){
    taxBrak=read.nextDouble();
    read.nextLine();
  }
  public void ModifyNations(){
    System.out.println("Enter your new interest rate");
    GrabUserNum();
    System.out.println("What is your new max Tax Bracket?");
    GrabTaxBrak();
    System.out.println("Put in your new budget as a series of 6 values, seperated by Spaces.\nYour catagories are manufacturing, welfare, healthcare, salaries, military, other");
    GrabUserInput();
    nation.adjustInstanceVariables(userIn,interestNum,taxBrak, nation);
//adjustInstanceVariables(double[] governmentBudget, double newinterestRate, double newMaxBracket, nation);

/*
    if(userIn.equals("Taxes")){
      nation.updateTaxRevenue(budgetNum);
    }
    else if(userIn.equals("Interest")){
      adjustInstanceVariables(governmentBudget, budgetNum, double newMaxBracket, nation);
    }
    else if(userIn.equals("Budget")){
      System.out.println("Which line item? Manufacturing, Welfare, Healthcare, Salaries, Military, Other?");
      GrabUserInput();
      double[] bud=nation.getGovBudgetBreakDown();
      if(userIn.equals("Manufacturing")){
        bud[0]+=budgetNum;
      }
      else if(userIn.equals("Welfare")){
        bud[1]+=budgetNum;
      }
      else if(userIn.equals("Healthcare")){
        bud[2]+=budgetNum;
      }
      else if(userIn.equals("Salaries")){
        bud[3]+=budgetNum;
      }
      else if(userIn.equals("Military")){
        bud[4]+=budgetNum;
      }
      else if(userIn.equals("Other")){
        bud[5]+=budgetNum;
      }
      nation.setGovernmentSpending(bud);

    }
*/
  }
  public boolean initializeNation(){
    nation=Germany;
    //Use initializeNation to get code when we integrate other stuff in, use userIn for that
    return false;
  }
  public void GrabConditions(){
    System.out.println("Tax Rev: "+ nation.getTaxRevenue()+"\nConsumerSpending: "
      +nation.getConsumerSpending()+"\nGDPGrowthRate: "+nation.getGDPGrowthRate()+
      "\nInflation & Debt: "+ nation.getinflationRate()+" & "+nation.nationalDebt()
      +"\nJoy: "+nation.getJoy());

  }


  public void run(){
      GrabUserInput();
      initializeNation();
      while(nation.getJoy()>0){
        GrabConditions();
        System.out.println("Your Move.");
        GrabUserInput();
        ModifyNations();
        nation.happened();
      }
      System.out.println("L + ratio + you got couped");
  }
  public static void main(String[] args) {
    run newSim=new run();
    newSim.run();
  }
    //Take the function for calculateGDPgrowth and use use userinputs
    //Add handling for bad inputs
}
