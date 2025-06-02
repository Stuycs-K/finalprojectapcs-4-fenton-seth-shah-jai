public class Bonds {
  private float valueOfBonds, interestRate, maturationTimeline;

  public Bonds(nationState nation) {
    interestRate = nation.getInterestRate() * nation.bondInterestModifier();
    maturationTimeline = 20;
    valueOfBonds = nation.getSpending() - nation.getSpendableTaxRevenue();
  }
  
  public Bonds(float valueOfBonds, float interestRate) {

    this.interestRate = interestRate;
    maturationTimeline = 20;
    this.valueOfBonds = valueOfBonds;
  }
  
  public float getValue() {
return valueOfBonds;
}

  public float getInterestRate() {
return interestRate;
}

public float getMaturationTimeline() {
return maturationTimeline;
}

public void decrementMaturationTimeline() {
maturationTimeline = maturationTimeline - 1;
}


}
