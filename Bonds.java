public class Bonds {
  private double valueOfBonds, interestRate, maturationTimeline;

  public Bonds(nationState nation) {
    interestRate = nation.getInterestRate() * nation.bondInterestModifier();
    maturationTimeline = 20;
    valueOfBonds = nation.getSpending() - nation.getspendableTaxRevenue();
  }
  
  public Bonds(double valueOfBonds, double interestRate) {
    interestRate = interestRate;
    maturationTimeline = 20;
    valueOfBonds = valueOfBonds;
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
