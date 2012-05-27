package prg_420;

/*******************************
 * Project : Salary Calculator *
 * Author  : Dave Schofield    *
 * Written : 2012/05/14        *
 * Version : 1.0               *
 * *****************************
 */

/**
 *
 * @author Dave
 */
import java.util.Scanner; // Needed for the Scanner class

public class salary
{
  /**
   * @param args the command line arguments
   */

  public static void main(String[] args)
  {
    // TODO code application logic here

    System.out.println("Starting");
    salary s1 = new salary();
    System.out.println("Getting 'RateCommission'");
    int RateCommission = s1.getRateCommission();
    System.out.println("Getting 'SalesAnnual'");
    int SalesAnnual = s1.getSalesAnnual();
    System.out.println("Getting 'SalaryBase'");
    int SalaryBase = s1.getSalaryBase();
    System.out.println("Setting 'SalaryCommission'");
    s1.setSalaryCommission(SalesAnnual, RateCommission);
    System.out.println("Getting 'SalaryCommmission'");
    int SalaryCommission = s1.getSalaryCommission();
    System.out.println("Setting 'SalaryTotal'");
    s1.setSalaryTotal(SalaryBase, SalaryCommission);
    System.out.println("Getting 'SalaryTotal'");
    int SalaryTotal = s1.getSalaryTotal();
    System.out.print("The 'Total Salary' is $ " +(SalaryTotal/100)+ "." + (SalaryTotal % 100) + "\n");
    System.out.println("Finished");

  }
  private int RateCommission;
  private int SalesAnnual;
  private int SalaryBase;
  private int SalaryCommission;
  private int SalaryTotal;
  private Scanner keyboard = new Scanner(System.in);

  public int getRateCommission()
  {
    RateCommission = 25;
    System.out.println("Commission Rate = " + RateCommission + "%");
    return RateCommission;
  }

  public int getSalesAnnual()
  {
    SalesAnnual = 1000;
    System.out.print("What are the Annual Sales Figures ?");
    SalesAnnual = keyboard.nextInt();
    System.out.println("Annual Sales = " + SalesAnnual + " Units");
    return SalesAnnual;
  }

  public int getSalaryBase()
  {
    SalaryBase = 7500000;
    System.out.println("Base Salary = $ " + SalaryBase/100);
    return SalaryBase;
  }

  public void setSalaryCommission(int AS, int RC)
  {
    System.out.println("Salary Commission = " + AS + " times " + RC + "%");
    SalaryCommission = (AS * RC);
    System.out.println("Salary Commission = $ " + SalaryCommission/100);
  }

  public int getSalaryCommission()
  {
    System.out.println("Commission = $ " + SalaryCommission/100);
    return SalaryCommission;
  }

  public void setSalaryTotal(int BS, int CS)
    {
      System.out.println("Salary Total = " + BS/100 + " plus " + CS/100);
      SalaryTotal = (BS + CS);
      System.out.println("Salary Total = $ " + SalaryTotal/100);
    }
  public int getSalaryTotal()
  {
    System.out.println("Total Salary = $ " + SalaryTotal/100);
    return SalaryTotal;
  }
}
