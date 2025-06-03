public class Bonds {
  private double valueOfBonds, interestRate, maturationTimeline;

  public Bonds(nationState nation) {
    interestRate = nation.getInterestRate() * nation.bondInterestModifier();
    maturationTimeline = 20;
    valueOfBonds = nation.getSpending() - nation.getSpendableTaxRevenue();
  }
  
  public Bonds(double valueOfBonds, double interestRate) {

    this.interestRate = interestRate;
    maturationTimeline = 20;
    this.valueOfBonds = valueOfBonds;
  }
  
  public double getValue() {
return valueOfBonds;
}

  public double getInterestRate() {
return interestRate;
}

public double getMaturationTimeline() {
return maturationTimeline;
}

public void decrementMaturationTimeline() {
maturationTimeline = maturationTimeline - 1;
}


}
