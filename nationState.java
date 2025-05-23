public class nationState {
  //I think we have to do an ArrayListOfBonds
 private static double globalGDP, GEGM, GlobalGDPGrowth, year;
 //including no way to modify net exports for now but that will change
 private double ConsumerSpending, Investment, GovernmentSpending, Exports, Imports, DefaultGDPGrowthRate, interestRate, inflationRate,nationalSpending, taxRevenue, nationalDebt, gdpModifier;
//government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//means every array will range from index 0 to index 6
private double[] govBudgetBreakDown;

public nationState(double ConsumerSpending, double Investment, double GovernmentSpending, double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate,double nationalSpending, double[] govBudgetBreakDown, double taxRevenue, double nationalDebt) {
  consumerSpending = consumerSpending;
  Investment = Investment;
  GovernmentSpending = GovernmentSpending;
  Exports = Exports;
  Imports = Imports;
  DefaultGDPGrowthRate = DefaultGDPGrowthRate;
  interestRate = interestRate;
  inflationRate = inflationRate;
  totalNationalSpending = nationalSpending;
  GovernmentBudgetBreakdown = GovernmentBudgetBreakdown;
  taxRevenue = taxRevenue;
  gdpModifier=0;


}

public double findBudgetBalence() {
 return taxRevenue - totalNationalSpending;
}

public double GDP() {
  return GovernmentSpending + (Exports - Imports) + Investment + consumerSpending + gdpModifier;
}

public double RealGDP() {
 return GDP / (1 + inflationRate);
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

public void changeDefaultGDPGrowthRate(double change){
  DefaultGDPGrowthRate+=change;
}

public void changeGDP(double change){
  gdpModifier+=change;
}

}
