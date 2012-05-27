package prg_420;


/**
 * Project : Salary Calculator Author : Dave Schofield Written : 2012/05/14
 * Version : 1.0
 */
/**
 *
 * @author Dave
 */
public class salarycalculator // Name of the Class
{

  public static void main(String[] args)
  {
    System.out.println("## Starting 'public static void main(String{} args)' ##");
    resetVariables();
  }







  private static void resetVariables()
  {
    // Declare variables
    double RateCommission = -1.11;    // Define variable with default fake value
    double SalesAnnual = -2.22;    // Define variable with default fake value
    double SalaryBase = -3.33;    // Define variable with default fake value
    double SalaryCommission = -4.44;    // Define variable with default fake value
    double SalaryTotal = -5.55;    // Define varoable with default fake value

    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void setRateCommission(double RC) {
    RateCommission = RC;
  }
  private double RateCommission;
}