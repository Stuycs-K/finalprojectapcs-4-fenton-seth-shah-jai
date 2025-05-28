import java.util.*;
public class nationState {
  //I think we have to do an ArrayListOfBonds
 private static double globalGDP = 110060;
 private static double GEGM = 1;
 private static double GlobalGDPGrowth = .034;
  private static double year = 2024;
 //including no way to modify net exports for now but that will change
 private double consumerSpending, Investment, Exports, Imports, GDPGrowthRate, interestRate, inflationRate, taxRevenue, nationalDebt, maxTaxBracket, joy;
 private ArrayList<Bonds> listOfBonds;
//government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//means every array will range from index 0 to index 6
private double[] govBudgetBreakDown;

public nationState(double ConsumerSpending, double Investment, double GovernmentSpending, double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate, double[] govBudgetBreakDown, double taxRevenue, double nationalDebt, double maxTaxBracket) {
  consumerSpending = ConsumerSpending;
  Investment = Investment;
  Exports = Exports;
  Imports = Imports;
  GDPGrowthRate = DefaultGDPGrowthRate;
  interestRate = interestRate;
  inflationRate = inflationRate;
  govBudgetBreakDown = govBudgetBreakDown;
  taxRevenue = taxRevenue;
  listOfBonds = new ArrayList<Bonds>(0);
  maxTaxBracket = maxTaxBracket;
  joy = joy;



}

public double updateTaxRevenue(double newMaxBracket) {
oldTaxBracket = setMaxBracket(newMaxBracket);
oldTaxRevenue = taxRevenue;
taxRevenue = (1 + GDPGrowthRate) * taxRevenue * maxTaxBracket / oldTaxBracket;
return oldTaxRevenue;

}

public double getJoy() {
  return joy;
}

public double setMaxBracket(double newMaxBracket) {
  oldTaxBracket = maxTaxBracket;
  maxTaxBracket = newMaxBracket;
  return oldTaxBracket;
}

public double governmentSpending() {
  double govSpendingSum = 0;
  for (int i = 0; i < govBudgetBreakDown.length; i++) {
    govSpendingSum += govBudgetBreakDown[i];
  }
 return govSpendingSum;
}
public double netExports() {
return Exports - Imports;
}


public double findBudgetBalence() {
 return taxRevenue - governmentSpending();
}

public double[] setGovernmentSpending(double[] govSpending) {
oldGovSpending = govBudgetBreakDown;
govBudgetBreakDown = govSpending;
return oldGovSpending;
}

public double GDP() {
  return governmentSpending() + (Exports - Imports) + Investment + consumerSpending;
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
  return governmentSpending();
}

public double calcInflation(double oldTaxRevenue, double oldInterestRate, double oldGovSpending) {
  return (oldTaxRevenue / taxRevenue) * .3 + (interestRate + 1) / (oldInterestRate + 1) * .3 + (governmentSpending() / oldGovSpending) * .4);
}

public double setInflationRate(double newInflationRate) {
 oldInflationRate = inflationRate;
 inflationRate = newInflationRate;
 return oldInflationRate;
}


public double setInterestRate(double newInterestRate) {
 oldInterestRate = newInterestRate;
 InterestRate = newInterestRate;
 return InterestRate;
}

public double calculateGDPGrowthToMultiplyBySpendingRatio (double initialCoefficent, double totalPercentChange) {
return initialCoefficent / (totalPercentChange  * 4 + 8);
}

public double calcGDPGrowthBySector(double[] oldGovernmentBudget) {
  //government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
double manufacturing = ((govBudgetBreakDown[0] - oldGovernmentBudget[0])/ oldGovernmentBudget[0]) * calculateGDPGrowthToMultiplyBySpendingRatio(2.1, (govBudgetBreakDown[0] - oldGovernmentBudget[0])/ oldGovernmentBudget[0]);
double welfare =  ((govBudgetBreakDown[1] - oldGovernmentBudget[1])/ oldGovernmentBudget[1]) * calculateGDPGrowthToMultiplyBySpendingRatio(1.3, (govBudgetBreakDown[1] - oldGovernmentBudget[1])/ oldGovernmentBudget[1]);
double healthcare =  (govBudgetBreakDown[2] - oldGovernmentBudget[2])/ oldGovernmentBudget[2] * calculateGDPGrowthToMultiplyBySpendingRatio(1.4, (govBudgetBreakDown[2] - oldGovernmentBudget[2])/ oldGovernmentBudget[2]);
double salaries = govBudgetBreakDown[3] - oldGovernmentBudget[3])/ oldGovernmentBudget[3]) * calculateGDPGrowthToMultiplyBySpendingRatio(1.7, (govBudgetBreakDown[3] - oldGovernmentBudget[3])/ oldGovernmentBudget[3]);
double millitary = (govBudgetBreakDown[4] - oldGovernmentBudget[4])/ oldGovernmentBudget[4] * calculateGDPGrowthToMultiplyBySpendingRatio(1.8,(govBudgetBreakDown[4] - oldGovernmentBudget[4])/ oldGovernmentBudget[4]);
double anythingElse = (govBudgetBreakDown[5] - oldGovernmentBudget[5])/ oldGovernmentBudget[5] * calculateGDPGrowthToMultiplyBySpendingRatio(1.9,(govBudgetBreakDown[5] - oldGovernmentBudget[5])/ oldGovernmentBudget[5]);
double arrayToReturn = {manufacturing, welfare, healthcare, salaries, millitary, anythingElse};
return arrayToReturn;

}


public double calculateGDPGrowth(double[] governmentBudget, double newinterestRate, double newMaxBracket) {
  oldTaxRevenue = updateTaxRevenue(newMaxBracket);
  oldGovernmentBudget = setGovernmentSpending(governmentBudget);
  oldInterestRate = setInterestRate(newinterestRate);
  double oldTotalGovernmentSpending = 0;
  for (int i = 0; i < oldGovernmentBudget.length; i++) {
oldTotalGovernmentSpending += oldGovernmentBudget[i];
  }
    oldInflationRate = setInflationRate(calcInflation(oldTaxRevenue, oldInterestRate,oldTotalGovernmentSpending));
  double[] govGrowthBreakdown = calcGDPGrowthBySector(oldGovernmentBudget);
  double govGrowthSum = 0;
  for (int n = 0; n < govGrowthBreakdown.length; n++) {
  govGrowthSum += govGrowthBreakdown[n];
  }
  
  
  return GEGM * (govGrowthSum + ((oldInterestRate /  newinterestRate) - 1) - ((taxRevenue /  oldTaxRevenue) - 1) * (inflationRate / oldInflationRate));
}

public double adjustInstanceVariables(double[] governmentBudget, double newinterestRate, double newMaxBracket) {
calculateGDPGrowth(governmentBudget, newinterestRate,newMaxBracket);

}




}
