
import java.util.*;
public class nationState {
  //I think we have to do an ArrayListOfBonds
 private static double globalGDP = 110060;
 private static double GEGM = 1;
 private static double GlobalGDPGrowth = .034;
  private static double year = 2024;
 //including no way to modify net exports for now but that will change
 private String name;
 private double consumerSpending, Investment, Exports, Imports, GDPGrowthRate, interestRate, inflationRate, taxRevenue,initialnationalDebt, maxTaxBracket, joy, initialInterestPayment, spendableTaxRevenue, population, populationGrowthRate, DefaultGDPGrowthRate;
 private ArrayList<Bonds> listOfBonds;
//government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//means every array will range from index 0 to index 6
private double[] govBudgetBreakDown;
//change

public nationState(String name, double populationGrowthRate,double ConsumerSpending, double Investment,  double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate,double initialInterestPayment,double population, double[] govBudgetBreakDown, double taxRevenue, double initialnationalDebt, double maxTaxBracket, double spendableTaxRevenue, double joy) {
  this.name = name;
  this.GDPGrowthRate = DefaultGDPGrowthRate;
  this.consumerSpending = ConsumerSpending;
  this.Investment = Investment;
  this.Exports = Exports;
  this.Imports = Imports;
  this.DefaultGDPGrowthRate = DefaultGDPGrowthRate;
  this.interestRate = interestRate;
  this.inflationRate = inflationRate;
  this.govBudgetBreakDown = govBudgetBreakDown;
  this.taxRevenue = taxRevenue;
  listOfBonds = new ArrayList<Bonds>(0);
  this.maxTaxBracket = maxTaxBracket;
  this.joy = joy;
  this.initialInterestPayment = initialInterestPayment;
  this.initialnationalDebt = initialnationalDebt;
  this.spendableTaxRevenue = spendableTaxRevenue;
  this.population = population;
  this.populationGrowthRate = populationGrowthRate;
  listOfBonds.add(new Bonds(initialnationalDebt, initialInterestPayment / initialnationalDebt));




}

public double[] updateTaxRevenueWithoutGrowth(double newMaxBracket) {
double oldTaxBracket = setMaxBracket(newMaxBracket);
double oldTaxRevenue = taxRevenue;
taxRevenue = taxRevenue * maxTaxBracket / oldTaxBracket;
double[] thingsToReturn = {oldTaxBracket, oldTaxRevenue};
return thingsToReturn;

}

public double getJoy() {
return joy;
}

public String getName() {
 return name; 
}


public double nationalDebt() {
double nationalDebt = 0;
for (int i = 0; i < listOfBonds.size(); i++) {
nationalDebt += listOfBonds.get(i).getValue();

}
return nationalDebt;

}


public double getYear() {
return year;
}

public double interestPayment() {
double interestPayments = 0;
for (int i = 0; i < listOfBonds.size(); i++) {
interestPayments += listOfBonds.get(i).getValue() * listOfBonds.get(i).getInterestRate();

}
return interestPayments;

}

public double setMaxBracket(double newMaxBracket) {
  double oldTaxBracket = maxTaxBracket;
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
 return spendableTaxRevenue - getSpending();
}

public double[] setGovernmentSpending(double[] govSpending) {
double[] oldGovSpending = govBudgetBreakDown;
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

public double Investment() {
 return Investment; 
}

public double population() {
return population;  
}
public double getSpending() {
  return governmentSpending();
}


public double calcInflation(double oldTaxBracket, double oldInterestRate, double oldGovSpending) {
  return  ((1 + populationGrowthRate) * ((oldTaxBracket / maxTaxBracket) * .3 * 3 + (interestRate + 1) / (oldInterestRate + 1) * .3 + (governmentSpending() / oldGovSpending) * .4)) * 1 / 60;
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

public double getRealGDPGrowthRate() {
 return GDPGrowthRate / (1 + inflationRate); 
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
double[] arrayToReturn = {manufacturing * 2, welfare * 2, healthcare * 2, salaries * 2, millitary * 2, anythingElse * 2};
return arrayToReturn;

}

// make this output an array so that way you can collect all the numbers you need to calculate Joy
public double[] calculateGDPGrowth(double[] governmentBudget, double newinterestRate, double newMaxBracket) {
  double GDP = GDP();
  double[] oldTaxThings = updateTaxRevenueWithoutGrowth(newMaxBracket);
  double oldTaxRevenue = oldTaxThings[1];
  double oldTaxBracket = oldTaxThings[0];
  double[] oldGovernmentBudget = setGovernmentSpending(governmentBudget);
  double oldInterestRate = setInterestRate(newinterestRate);
  double oldTotalGovernmentSpending = 0;
  for (int i = 0; i < oldGovernmentBudget.length; i++) {
oldTotalGovernmentSpending += oldGovernmentBudget[i];
  }
    double oldInflationRate = setInflationRate(calcInflation(oldTaxBracket, oldInterestRate,oldTotalGovernmentSpending));
  double[] govGrowthBreakdown = calcGDPGrowthBySector(oldGovernmentBudget);
  double govGrowthSum = 0;
  for (int n = 0; n < govGrowthBreakdown.length; n++) {
  govGrowthSum += govGrowthBreakdown[n];
  }

  double[] arrayToReturn =  {(DefaultGDPGrowthRate * ((1 + populationGrowthRate) * (GEGM * (govGrowthSum * 10 + ((oldInterestRate /  newinterestRate) - 1) * 10 - (((maxTaxBracket /  oldTaxBracket)  - 1) * 10) * (inflationRate / oldInflationRate))) + 1) * .7), GDP, oldTaxRevenue, oldInterestRate, oldTotalGovernmentSpending, oldGovernmentBudget[1], oldGovernmentBudget[2], oldTaxBracket};
  return arrayToReturn;
}


public double calculateJoy(double gdpGrowth, double taxChange, double inflationRate, double nationalDebt, double oldHealthcare, double oldWelfare) {
  if (oldHealthcare / govBudgetBreakDown[1] - 1 != 0 && (oldWelfare / govBudgetBreakDown[2] - 1) != 0) {
  return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt / GDP() / 2) - ((oldHealthcare / govBudgetBreakDown[1] - 1) + (oldWelfare / govBudgetBreakDown[2] - 1)));
}
else if ((oldWelfare / govBudgetBreakDown[2] - 1) != 0) {
  return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt / GDP() / 2) - (oldWelfare / govBudgetBreakDown[2] - 1));

}
return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt /  GDP() / 2));

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

public double getSpendableTaxRevenue() {
return spendableTaxRevenue;
}

public double getMaxTaxBracket(){
  return maxTaxBracket;
}

public void adjustPopulationStatistics() {
  populationGrowthRate = populationGrowthRate * (GDPGrowthRate + 1 - inflationRate);
  population = population * (1 + populationGrowthRate);
}



public void adjustInstanceVariables(double[] governmentBudget, double newinterestRate, double newMaxBracket, nationState nationCurrentlyModelled) {
adjustPopulationStatistics();
double[] arrayOfThingsINeed = calculateGDPGrowth(governmentBudget, newinterestRate, newMaxBracket);
GDPGrowthRate = arrayOfThingsINeed[0];
taxRevenue = taxRevenue * (1 + GDPGrowthRate);
double newGDP;
if (1 + GDPGrowthRate > 0) {
 newGDP = arrayOfThingsINeed[1] * (1 + GDPGrowthRate);
}
else {
   newGDP = arrayOfThingsINeed[1] * Math.abs(1 + GDPGrowthRate);

}
//net Exports isn't included because it remains constant while this is only a domestic economic simulator, will figure out the implications of Net Exports in later reworks after minimum viable product is achieved
double newSumOfInvestmentConsumerAndNetExports = newGDP - governmentSpending();
double oldSumOfInvestmentConsumerAndNetExports = arrayOfThingsINeed[1] - arrayOfThingsINeed[4];
double differenceToBeDistributed = newSumOfInvestmentConsumerAndNetExports - oldSumOfInvestmentConsumerAndNetExports;
consumerSpending = consumerSpending + differenceToBeDistributed * .6;
Investment = Investment + differenceToBeDistributed * .4;
joy = calculateJoy(GDPGrowthRate, (maxTaxBracket / arrayOfThingsINeed[6]) - 1,inflationRate, nationalDebt(),arrayOfThingsINeed[5], arrayOfThingsINeed[6]) / 1.5;


GlobalGDPGrowth = GlobalGDPGrowth * GEGM;
globalGDP = (1 + GlobalGDPGrowth * globalGDP);
year++;
spendableTaxRevenue = taxRevenue;
spendableTaxRevenue = spendableTaxRevenue - interestPayment();
spendableTaxRevenue = spendableTaxRevenue - removeOldBonds();


issueBonds(nationCurrentlyModelled);
}

public double getConsumerSpending(){
  return consumerSpending;
}

public double getGDPGrowthRate(){
  return GDPGrowthRate;
}

public double getinflationRate(){
  return inflationRate;
}

public double[] getGovBudgetBreakDown(){
  return govBudgetBreakDown;
}

public double getGEGM(){
  return GEGM;
}

public double getPopulation() {
 return population;
}
public double getPopulationGrowthRate() {
  return populationGrowthRate;
}

public void setPopulationGrowthRate(double newPopulationGrowthRate) {
populationGrowthRate = newPopulationGrowthRate;
}

public void setJoy(double newJoy) {
 joy = newJoy; 
}



public void happened(){
  Random rand=new Random();
  double happen=rand.nextDouble();
  if(happen<0.3){
    Events.EventHappens(this);
  }

  else{
    System.out.println("Nothing ever happens");
  }
}

}
