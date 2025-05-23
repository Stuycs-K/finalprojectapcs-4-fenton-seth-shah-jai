public class Bonds {
  private double valueOfBonds, interestRate, maturationTimeline;

  public Bonds(nationState nation) {
    annualizedInterestRate = nation.getInterestRate();
    maturationTimeline = 20;
    valueOfBonds = nation.getSpending() - nation.getTaxRevenue();
  }
}
