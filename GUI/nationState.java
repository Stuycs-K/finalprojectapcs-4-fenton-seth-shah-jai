import java.util.*;
public class nationState {
  //I think we have to do an ArrayListOfBonds
 private static float globalGDP = 110060;
 private static float GEGM = 1;
 private static float GlobalGDPGrowth = .034;
  private static float year = 2024;
 //including no way to modify net exports for now but that will change
 private float consumerSpending, Investment, Exports, Imports, GDPGrowthRate, interestRate, inflationRate, taxRevenue,initialnationalDebt, maxTaxBracket, joy, initialInterestPayment, spendableTaxRevenue, population, populationGrowthRate, DefaultGDPGrowthRate;
 private ArrayList<Bonds> listOfBonds;
//government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//means every array will range from index 0 to index 6
private float[] govBudgetBreakDown;
//change

public nationState(float populationGrowthRate,float ConsumerSpending, float Investment,  float Exports, float Imports, float DefaultGDPGrowthRate, float interestRate, float inflationRate,float initialInterestPayment,float population, float[] govBudgetBreakDown, float taxRevenue, float initialnationalDebt, float maxTaxBracket, float spendableTaxRevenue, float joy) {
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

public float updateTaxRevenueWithoutGrowth(float newMaxBracket) {
float oldTaxBracket = setMaxBracket(newMaxBracket);
float oldTaxRevenue = taxRevenue;
taxRevenue = taxRevenue * maxTaxBracket / oldTaxBracket;
return oldTaxRevenue;

}

public float getJoy() {
return joy;
}


public float nationalDebt() {
float nationalDebt = 0;
for (int i = 0; i < listOfBonds.size(); i++) {
nationalDebt += listOfBonds.get(i).getValue();

}
return nationalDebt;

}

public float interestPayment() {
float interestPayments = 0;
for (int i = 0; i < listOfBonds.size(); i++) {
interestPayments += listOfBonds.get(i).getValue() * listOfBonds.get(i).getInterestRate();

}
return interestPayments;

}

public float setMaxBracket(float newMaxBracket) {
  float oldTaxBracket = maxTaxBracket;
  maxTaxBracket = newMaxBracket;
  return oldTaxBracket;
}

public float governmentSpending() {
  float govSpendingSum = 0;
  for (int i = 0; i < govBudgetBreakDown.length; i++) {
    govSpendingSum += govBudgetBreakDown[i];
  }
 return govSpendingSum;
}
public float netExports() {
return Exports - Imports;
}


public float findBudgetBalence() {
 return spendableTaxRevenue - getSpending();
}

public float[] setGovernmentSpending(float[] govSpending) {
float[] oldGovSpending = govBudgetBreakDown;
govBudgetBreakDown = govSpending;
return oldGovSpending;
}

public float GDP() {
  return governmentSpending() + (Exports - Imports) + Investment + consumerSpending;
}

public float RealGDP() {
 return GDP() / (1 + inflationRate);
}

public float getInterestRate() {
  return interestRate;
}

public float getTaxRevenue() {
  return taxRevenue;
}
public float getSpending() {
  return governmentSpending();
}


public float calcInflation(float oldTaxRevenue, float oldInterestRate, float oldGovSpending) {
  return  ((1 + populationGrowthRate) * ((oldTaxRevenue / taxRevenue) * .3 + (interestRate + 1) / (oldInterestRate + 1) * .3 + (governmentSpending() / oldGovSpending) * .4)) * 1 / 60;
}

public void setGEGM(float newGEGM) {
  GEGM = newGEGM;
}


public float bondInterestModifier(){
  float bondInterestModifier = 1;
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

public float setInflationRate(float newInflationRate) {
 float oldInflationRate = inflationRate;
 inflationRate = newInflationRate;
 return oldInflationRate;
}


public float setInterestRate(float newInterestRate) {
 float oldInterestRate = newInterestRate;
 interestRate = newInterestRate;
 return interestRate;
}

public float calculateGDPGrowthToMultiplyBySpendingRatio (float initialCoefficent, float totalPercentChange) {
return initialCoefficent / (totalPercentChange  * 4 + 8);
}

public ArrayList<Bonds> getListOfBonds() {
return listOfBonds;
}

public float returnSectorGrowth(int index, float coefficent, float[] oldGovernmentBudget) {
 return ((govBudgetBreakDown[index] - oldGovernmentBudget[index])/ oldGovernmentBudget[index]) * calculateGDPGrowthToMultiplyBySpendingRatio(coefficent, (govBudgetBreakDown[index] - oldGovernmentBudget[index])/ oldGovernmentBudget[index]);
}

public float[] calcGDPGrowthBySector(float[] oldGovernmentBudget) {
  //government budget breaks down into six core sectors, manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
float manufacturing = returnSectorGrowth(0, 2.1,oldGovernmentBudget);
float welfare = returnSectorGrowth(1, 1.3,oldGovernmentBudget);
float healthcare =  returnSectorGrowth(2, 1.4, oldGovernmentBudget);
float salaries = returnSectorGrowth(3, 1.7,oldGovernmentBudget);
float millitary = returnSectorGrowth(4, 1.8,oldGovernmentBudget);
float anythingElse = returnSectorGrowth(5, 1.9,oldGovernmentBudget);
float[] arrayToReturn = {manufacturing * 2, welfare * 2, healthcare * 2, salaries * 2, millitary * 2, anythingElse * 2};
return arrayToReturn;

}

// make this output an array so that way you can collect all the numbers you need to calculate Joy
public float[] calculateGDPGrowth(float[] governmentBudget, float newinterestRate, float newMaxBracket) {
  float GDP = GDP();
  float oldTaxRevenue = updateTaxRevenueWithoutGrowth(newMaxBracket);
  float[] oldGovernmentBudget = setGovernmentSpending(governmentBudget);
  float oldInterestRate = setInterestRate(newinterestRate);
  float oldTotalGovernmentSpending = 0;
  for (int i = 0; i < oldGovernmentBudget.length; i++) {
oldTotalGovernmentSpending += oldGovernmentBudget[i];
  }
    float oldInflationRate = setInflationRate(calcInflation(oldTaxRevenue, oldInterestRate,oldTotalGovernmentSpending));
  float[] govGrowthBreakdown = calcGDPGrowthBySector(oldGovernmentBudget);
  float govGrowthSum = 0;
  for (int n = 0; n < govGrowthBreakdown.length; n++) {
  govGrowthSum += govGrowthBreakdown[n];
  }

  float[] arrayToReturn =  {DefaultGDPGrowthRate * (((1 + populationGrowthRate) * (GEGM * (govGrowthSum + ((oldInterestRate /  newinterestRate) - 1) - (((taxRevenue /  oldTaxRevenue) - 1) * 1.5) * (inflationRate / oldInflationRate)))) + 1), GDP, oldTaxRevenue, oldInterestRate, oldTotalGovernmentSpending, oldGovernmentBudget[1], oldGovernmentBudget[2]};
  return arrayToReturn;
}


public float calculateJoy(float gdpGrowth, float taxChange, float inflationRate, float nationalDebt, float oldHealthcare, float oldWelfare) {
  if (oldHealthcare / govBudgetBreakDown[1] - 1 != 0 && (oldWelfare / govBudgetBreakDown[2] - 1) != 0) {
  return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt / GDP() / 40) - ((oldHealthcare / govBudgetBreakDown[1] - 1) + (oldWelfare / govBudgetBreakDown[2] - 1)));
}
else if ((oldWelfare / govBudgetBreakDown[2] - 1) != 0) {
  return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt / GDP() / 40) - (oldWelfare / govBudgetBreakDown[2] - 1));

}
return joy * ((1 + gdpGrowth * 3) - (taxChange + inflationRate + nationalDebt  /  GDP() / 40));

  }


public static void issueBonds(nationState newNationState) {
newNationState.getListOfBonds().add(new Bonds(newNationState));


}

public float removeOldBonds() {
float valueOfOldBondsToRepay = 0;
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

public float getSpendableTaxRevenue() {
return spendableTaxRevenue;
}

public float getMaxTaxBracket(){
  return maxTaxBracket;
}

public void adjustPopulationStatistics() {
  populationGrowthRate = populationGrowthRate * (GDPGrowthRate + 1 - inflationRate);
  population = population * populationGrowthRate;
}



public void adjustInstanceVariables(float[] governmentBudget, float newinterestRate, float newMaxBracket, nationState nationCurrentlyModelled) {
adjustPopulationStatistics();
float[] arrayOfThingsINeed = calculateGDPGrowth(governmentBudget, newinterestRate, newMaxBracket);
GDPGrowthRate = arrayOfThingsINeed[0];
taxRevenue = taxRevenue * (1 + GDPGrowthRate);
float newGDP = arrayOfThingsINeed[1] * (1 + GDPGrowthRate);
//net Exports isn't included because it remains constant while this is only a domestic economic simulator, will figure out the implications of Net Exports in later reworks after minimum viable product is achieved
float newSumOfInvestmentConsumerAndNetExports = newGDP - governmentSpending();
float oldSumOfInvestmentConsumerAndNetExports = arrayOfThingsINeed[1] - arrayOfThingsINeed[4];
float differenceToBeDistributed = newSumOfInvestmentConsumerAndNetExports - oldSumOfInvestmentConsumerAndNetExports;
consumerSpending = consumerSpending + differenceToBeDistributed * .6;
Investment = Investment + differenceToBeDistributed * .4;
joy = calculateJoy(GDPGrowthRate, (taxRevenue / arrayOfThingsINeed[2]) - 1,inflationRate, nationalDebt(),arrayOfThingsINeed[5], arrayOfThingsINeed[6]);
GlobalGDPGrowth = GlobalGDPGrowth * GEGM * 2;
globalGDP = GlobalGDPGrowth * globalGDP;
year++;
spendableTaxRevenue = taxRevenue;
spendableTaxRevenue = spendableTaxRevenue - interestPayment();
spendableTaxRevenue = spendableTaxRevenue - removeOldBonds();


issueBonds(nationCurrentlyModelled);
}

public float getConsumerSpending(){
  return consumerSpending;
}

public float getGDPGrowthRate(){
  return GDPGrowthRate;
}

public float getinflationRate(){
  return inflationRate;
}

public float[] getGovBudgetBreakDown(){
  return govBudgetBreakDown;
}

public float getGEGM(){
  return GEGM;
}

public float getPopulation() {
 return population;
}
public float getPopulationGrowthRate() {
  return populationGrowthRate;
}

public float setPopulationGrowthRate() {
  return populationGrowthRate;
}
public void happened(){
  Random rand=new Random();
  float happen=rand.nextfloat();
  if(happen<0.3){
    Events.EventHappens(this);
  }

  else{
    System.out.println("Nothing ever happens");
  }
}

}
