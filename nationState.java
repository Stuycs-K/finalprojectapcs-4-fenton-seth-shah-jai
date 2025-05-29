import java.util.*;
public class nationState {
  //I think we have to do an ArrayListOfBonds
 private static double globalGDP, GEGM, GlobalGDPGrowth, year;
 //including no way to modify net exports for now but that will change
 private double consumerSpending, Investment, GovernmentSpending, Exports, Imports, DefaultGDPGrowthRate, interestRate, inflationRate,nationalSpending, taxRevenue, nationalDebt;
 private ArrayList<Bonds> listOfBonds;
//government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//means every array will range from index 0 to index 6
private double[] govBudgetBreakDown;

public nationState(double ConsumerSpending, double Investment, double GovernmentSpending, double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate, double[] govBudgetBreakDown, double taxRevenue, double nationalDebt) {
  consumerSpending = ConsumerSpending;
  Investment = Investment;
  GovernmentSpending = GovernmentSpending;
  Exports = Exports;
  Imports = Imports;
  DefaultGDPGrowthRate = DefaultGDPGrowthRate;
  interestRate = interestRate;
  inflationRate = inflationRate;
  govBudgetBreakDown = govBudgetBreakDown;
  taxRevenue = taxRevenue;
  listOfBonds = new ArrayList<Bonds>(0);



}

public double findBudgetBalence() {
 return taxRevenue - GovernmentSpending;
}

public double GDP() {
  return GovernmentSpending + (Exports - Imports) + Investment + consumerSpending + gdpModifier;
}

public double RealGDP() {
 return GDP() / (1 + inflationRate);
}

public double getInterestRate() {
  return interestRate;
}

public double getTaxRevenue() {
  return taxRevenue;
}
public double getSpending() {
  return GovernmentSpending;
}

<<<<<<< Updated upstream
public void changeDefaultGDPGrowthRate(double change){
  DefaultGDPGrowthRate+=change;
=======

public double calcInflation(double oldTaxRevenue, double oldInterestRate, double oldGovSpending) {
  return (oldTaxRevenue / taxRevenue) * .3 + (interestRate + 1) / (oldInterestRate + 1) * .3 + (governmentSpending() / oldGovSpending) * .4;
}

public void setGEGM(double newGEGM) {
  GEGM = newGEGM;
}


public double bondInterestModifier(){
  double bondInterestModifier = 1;
  if (nationalDebt() <= GDP()) {
return bondInterestModifier;
  }
  else if (nationalDebt() <= 1.25 * GDP()) {
    bondInterestModifier = 1.1;
  }
  else if (nationalDebt() <= 1.75 * GDP()) {
    bondInterestModifier = 1.3;
  }
  else if (nationalDebt() <= 2 * GDP()) {
    bondInterestModifier = 1.8;
  }
  else {
    bondInterestModifier = nationalDebt() / GDP();
  }
  return bondInterestModifier;

}

public double setInflationRate(double newInflationRate) {
 double oldInflationRate = inflationRate;
 inflationRate = newInflationRate;
 return oldInflationRate;
}


public double setInterestRate(double newInterestRate) {
 double oldInterestRate = newInterestRate;
 interestRate = newInterestRate;
 return interestRate;
}

public double calculateGDPGrowthToMultiplyBySpendingRatio (double initialCoefficent, double totalPercentChange) {
return initialCoefficent / (totalPercentChange  * 4 + 8);
}

public ArrayList<Bonds> getListOfBonds() {
return listOfBonds;
}

public double returnSectorGrowth(int index, double coefficent, double[] oldGovernmentBudget) {
 return ((govBudgetBreakDown[index] - oldGovernmentBudget[index])/ oldGovernmentBudget[index]) * calculateGDPGrowthToMultiplyBySpendingRatio(coefficent, (govBudgetBreakDown[index] - oldGovernmentBudget[index])/ oldGovernmentBudget[index]);
}

public double[] calcGDPGrowthBySector(double[] oldGovernmentBudget) {
  //government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
double manufacturing = returnSectorGrowth(0, 2.1,oldGovernmentBudget);
double welfare = returnSectorGrowth(1, 1.3,oldGovernmentBudget);
double healthcare =  returnSectorGrowth(2, 1.4, oldGovernmentBudget);
double salaries = returnSectorGrowth(3, 1.7,oldGovernmentBudget);
double millitary = returnSectorGrowth(4, 1.8,oldGovernmentBudget);
double anythingElse = returnSectorGrowth(5, 1.9,oldGovernmentBudget);
double[] arrayToReturn = {manufacturing, welfare, healthcare, salaries, millitary, anythingElse};
return arrayToReturn;

}

// make this output an array so that way you can collect all the numbers you need to calculate Joy
public double[] calculateGDPGrowth(double[] governmentBudget, double newinterestRate, double newMaxBracket) {
  double GDP = GDP();
  double oldTaxRevenue = updateTaxRevenueWithoutGrowth(newMaxBracket);
  double[] oldGovernmentBudget = setGovernmentSpending(governmentBudget);
  double oldInterestRate = setInterestRate(newinterestRate);
  double oldTotalGovernmentSpending = 0;
  for (int i = 0; i < oldGovernmentBudget.length; i++) {
oldTotalGovernmentSpending += oldGovernmentBudget[i];
  }
    double oldInflationRate = setInflationRate(calcInflation(oldTaxRevenue, oldInterestRate,oldTotalGovernmentSpending));
  double[] govGrowthBreakdown = calcGDPGrowthBySector(oldGovernmentBudget);
  double govGrowthSum = 0;
  for (int n = 0; n < govGrowthBreakdown.length; n++) {
  govGrowthSum += govGrowthBreakdown[n];
  }

  double[] arrayToReturn =  {GEGM * (govGrowthSum + ((oldInterestRate /  newinterestRate) - 1) - ((taxRevenue /  oldTaxRevenue) - 1) * (inflationRate / oldInflationRate)), GDP, oldTaxRevenue, oldInterestRate, oldTotalGovernmentSpending};
  return arrayToReturn;
}

public double calculateJoy(double gdpGrowth, double taxChange, double inflationRate, double nationalDebt) {
  return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt / GDP() / 40));
}

public static void issueBonds(nationState newNationState) {
newNationState.getListOfBonds().add(new Bonds(newNationState));

}

public double removeOldBonds() {
double valueOfOldBondsToRepay = 0;
for (int i = 0; i < listOfBonds.size(); i++) {
listOfBonds.get(i).decrementMaturationTimeline();
if (listOfBonds.get(i).getMaturationTimeline() == 0) {
valueOfOldBondsToRepay += listOfBonds.get(i).getValue();
listOfBonds.remove(i);
i--;
}

}
return valueOfOldBondsToRepay;

}


public void adjustInstanceVariables(double[] governmentBudget, double newinterestRate, double newMaxBracket, nationState nationCurrentlyModelled) {
double[] arrayOfThingsINeed = calculateGDPGrowth(governmentBudget, newinterestRate, newMaxBracket);
GDPGrowthRate = arrayOfThingsINeed[0];
taxRevenue = taxRevenue * (1 + GDPGrowthRate);
double newGDP = arrayOfThingsINeed[1] * GDPGrowthRate;
//net Exports isn't included because it remains constant while this is only a domestic economic simulator, will figure out the implications of Net Exports in later reworks after minimum viable product is achieved
double newSumOfInvestmentConsumerAndNetExports = newGDP - governmentSpending();
double oldSumOfInvestmentConsumerAndNetExports = arrayOfThingsINeed[1] - arrayOfThingsINeed[4];
double differenceToBeDistributed = newSumOfInvestmentConsumerAndNetExports - oldSumOfInvestmentConsumerAndNetExports;
consumerSpending = consumerSpending + differenceToBeDistributed * .6;
Investment = Investment + differenceToBeDistributed * .4;
joy = calculateJoy(GDPGrowthRate, (taxRevenue - arrayOfThingsINeed[2]) - 1,inflationRate, nationalDebt());
GlobalGDPGrowth = GlobalGDPGrowth * GEGM;
globalGDP = GlobalGDPGrowth * globalGDP;
year++;
taxRevenue = taxRevenue - interestPayment();
taxRevenue = taxRevenue - removeOldBonds();


issueBonds(nationCurrentlyModelled);
}

public double getConsumerSpending(){
  return consumerSpending;
>>>>>>> Stashed changes
}

public double getGDPGrowthRate(){
  return GDPGrowthRate;
}

public double  getinflationRate(){
  return inflationRate;
}


public double[] getGovBudgetBreakDown(){
  return govBudgetBreakDown;
}

public double getGEGM(){
  return GEGM;
}


public void happened(){
  Random rand=new Random();
  double happen=rand.nextDouble();
  if(happen<0.3){
    //Access the bad list of events
  }

  else{
    System.out.println("Nothing ever happens");
  }
}

}
