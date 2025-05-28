public class Bonds {
  private double valueOfBonds, interestRate, maturationTimeline;

  public Bonds(nationState nation) {
    interestRate = nation.getInterestRate() * nation.bondInterestModifier();
    maturationTimeline = 20;
    valueOfBonds = nation.getSpending() - nation.getTaxRevenue();
  }
}
