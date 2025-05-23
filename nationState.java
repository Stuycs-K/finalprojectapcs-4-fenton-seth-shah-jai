import java.util.*;
public class nationState {
  //I think we have to do an ArrayListOfBonds
 private static double globalGDP, GEGM, GlobalGDPGrowth, year;
 //including no way to modify net exports for now but that will change
 private double consumerSpending, Investment, GovernmentSpending, Exports, Imports, GDPGrowthRate, interestRate, inflationRate,nationalSpending, taxRevenue, nationalDebt, maxTaxBracket, oldTaxBracket;
 private ArrayList<Bonds> listOfBonds;
//government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//means every array will range from index 0 to index 6
private double[] govBudgetBreakDown;

public nationState(double ConsumerSpending, double Investment, double GovernmentSpending, double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate, double[] govBudgetBreakDown, double taxRevenue, double nationalDebt, double maxTaxBracket) {
  consumerSpending = ConsumerSpending;
  Investment = Investment;
  GovernmentSpending = GovernmentSpending;
  Exports = Exports;
  Imports = Imports;
  GDPGrowthRate = DefaultGDPGrowthRate;
  interestRate = interestRate;
  inflationRate = inflationRate;
  govBudgetBreakDown = govBudgetBreakDown;
  taxRevenue = taxRevenue;
  listOfBonds = new ArrayList<Bonds>(0);
  maxTaxBracket = maxTaxBracket;



}

public void updateTaxRevenue() {
taxRevenue = (1 + GDPGrowthRate) * taxRevenue * maxTaxBracket / oldTaxBracket;
oldTaxBracket = maxTaxBracket;
}

public void setMaxBracket(double newMaxBracket) {
  oldTaxBracket = maxTaxBracket;
  maxTaxBracket = newMaxBracket;
}

public double netExports() {
return Exports - Imports;
}


public double findBudgetBalence() {
 return taxRevenue - GovernmentSpending;
}

public double GDP() {
  return GovernmentSpending + (Exports - Imports) + Investment + consumerSpending;
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





}
