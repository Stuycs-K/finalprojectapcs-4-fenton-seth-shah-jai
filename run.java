import java.util.*;
public class run{
  private double[] userIn;
  private Double taxBrak, interestNum;
  private nationState nation;
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
  //double populationGrowthRate,double ConsumerSpending, double Investment,  double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate,double initialInterestPayment,double population, double[] govBudgetBreakDown, double taxRevenue, double initialnationalDebt, double maxTaxBracket, double spendableTaxRevenue, double joy
    nation=new nationState(0.01,2000.0,800.0,500.0,400.0,0.02,0.03,0.015,20.0,83000000,new double[]{100.0, 200.0, 150.0, 250.0, 300.0, 100.0},915.9,2000.0,0.45,1400.0, 50.0);
    //Use initializeNation to get code when we integrate other stuff in, use userIn for that
    return false;
  }
  public void GrabConditions(){
    System.out.println("GDP: " + nation.GDP() + "\nReal GDP: " + nation.RealGDP() +  "\nTax Rev: "+ nation.getTaxRevenue()+"\nConsumerSpending: "
      +nation.getConsumerSpending()+"\nGDPGrowthRate: "+nation.getGDPGrowthRate()+
      "\nInflation: "+ nation.getinflationRate()+"\nNational Debt: " +nation.nationalDebt()
      +"\nJoy: "+nation.getJoy()+"\nYour Budget: " + Arrays.toString(nation.getGovBudgetBreakDown())
      +"\nMax Tax Bracket: " + nation.getMaxTaxBracket() + "\nInterest Rate: " + nation.getInterestRate() + "\nDeficit:" + nation.findBudgetBalence() + "\nInterest Payment:" + nation.interestPayment() + "\nYear: " + nation.getYear());

  }


  public void run(){
      initializeNation();
      //System.out.println(nation.getJoy());
      while(nation.getJoy()>20){
        GrabConditions();
        System.out.println("Your Move.");
        ModifyNations();
        nation.happened();
       //System.out.println(nation.getJoy());
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
