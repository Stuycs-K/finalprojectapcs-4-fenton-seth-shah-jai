import java.util.*;
public class run{
  private double[] userIn;
  private Double taxBrack, interestNum;
  private nationState nation;
  nationState Germany=new nationState(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, 0.0, 0.0, 0.0, 0.0);



  public void GrabUserInput(){
    Scanner read=new Scanner(System.in);
    String reading=read.nextLine();

  }
  public void GrabUserNum(){
    Scanner read=new Scanner(System.in);
    interestNum=read.nextDouble();
  }
  public void GrabTaxBrak(){
    Scanner read=new Scanner(System.in);
    taxBrak=read.nextDouble();
  }
  public void ModifyNations(){
    System.out.println("And how much?");
    GrabUserNum();
    System.out.println("What is your new max Tax Bracket?");
    GrabTaxBrak();
    if(budgetNum.equals(0.0)){
      System.out.println("Nope, its 1");
      budgetNum=1.0;
    }
    adjustInstanceVariables(userIn,interestNum,taxBrak, nation);
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
        System.out.println("Your Move. What are you changing the budget to. Write out the list.");
        GrabUserInput();
        ModifyNations();
        happened();
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
