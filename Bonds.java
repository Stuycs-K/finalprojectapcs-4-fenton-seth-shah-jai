public class Bonds {
  private double valueOfBonds, interestRate, maturationTimeline;

  public Bonds(nationState nation) {
    annualizedInterestRate = nation.getInterestRate();
    maturationTimeline = 240;
    valueOfBonds = nation.getSpending() - nation.getTaxRevenue();
  }
}
