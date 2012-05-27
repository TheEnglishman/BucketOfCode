package prg_420;

// Import declarations
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Dave Schofield
 * @version 1.0
 * @date 2012/05/28
 **/
public class prg420_wk4_ia
{
  /**
  * @param args the command line arguments
  * @throws IOException
  */

  public static void main(String[] args) throws IOException
  {
    ArrayList<String> salesman = new ArrayList<>();  // Creates the Array List.
    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));  // Used to read input from user.
    Scanner uiKeyboard = new Scanner(System.in);  // User Input object to read keyboard input
    int uiSalesPersonCount;  // An integer variable to hold user input 'Sales Person Count'


// Get the number of Sales Persons & the associated names
    System.out.println("Please enter the number of Sales Persons: ");
    uiSalesPersonCount=uiKeyboard.nextInt();
    System.out.println("The number of Sales Persons is "+uiSalesPersonCount);
    while(uiSalesPersonCount<1)
    {
      System.out.println("You have entered an invalid value!");
      System.out.println("Please enter the number of Sales Persons: ");
      uiSalesPersonCount=uiKeyboard.nextInt();
    }
    int index=0;
    while (index<uiSalesPersonCount)
    {
      System.out.println("Please enter the name of the Sales Person Number "+(index+1)+": ");
      String name = userInput.readLine();
      int nameLength = name.length();
      while (nameLength == 0)
      {
        System.out.println("You have not entered a name.");
        System.out.println("");
        System.out.println("Please enter the name of the Sales Person Number "+(index+1)+": ");
        name = userInput.readLine();
        nameLength = name.length();
      }
      salesman.add(index,name);
    calculations_wk4 sp1 = new calculations_wk4();  // Create a new object of class Calculations

    sp1.setAnnualSales(0.00);  // Pass default value for 'Annual Sales' to function
    sp1.setAnnualSalesAdjusted(0.00);  // Pass default value for 'Annual Sales Adjusted' to function
    sp1.setCommissionRate(0.40);  // Pass value for 'Base Commission Rate' to function
    sp1.setCommissionRateAccelerator(1.25);  // Pass value for 'Commission Rate Accelerator' to function
    sp1.setSalaryBase(75000.00);  // Pass value for 'Base Salary' to function
    sp1.setSalaryCommission(1.00, 0.01, 2.00, 0.02);  // Pass values to set default 'Commission' to function
    sp1.setSalaryTotal(1.00, 0.50);  // Pass value to set default 'Total Salary' to function
    sp1.setSalesTarget(125000.00);  // Pass value for 'Sales Target' to function

// Build (variable) 'Mutator' values
    double vCommissionRate=sp1.getCommissionRate();
    double vCommissionRateAccelerator=sp1.getCommissionRateAccelerator();
    double vSalaryBase=sp1.getSalaryBase();
    double vSalesTarget=sp1.getSalesTarget();

    // User Input Request method
    double uiAnnualSales=sp1.getAnnualSales();  // Prompt user to enter 'Annual Sales' value

    //Logic for calculation steps
    sp1.setAnnualSalesAdjusted(uiAnnualSales); // Set new 'Annual Sales Adjusted' value
    double tempAnnualSales=uiAnnualSales;
    double cAnnualSalesAdjusted=sp1.getAnnualSalesAdjusted();

    System.out.println();  // Intentional blank line (carriage return)
    System.out.println("Annual Sales\t$"+uiAnnualSales);  // Informational Statement
    System.out.println("Sales Target\t$"+vSalesTarget);  // Informational Statement
    System.out.println("Sales Incentive Threshold\t$"+(vSalesTarget*0.80));  // Informational Statement
    System.out.println("Adjusted Annual Sales\t$"+cAnnualSalesAdjusted);  // Informational Statement
    System.out.println();  // Intentional blank line (carriage return)

    // While Loop
    while (tempAnnualSales<=cAnnualSalesAdjusted)
    {
      sp1.setSalaryCommission(tempAnnualSales, vCommissionRate, vSalesTarget, vCommissionRateAccelerator);
      double cSalaryCommission=sp1.getSalaryCommission();
      sp1.setSalaryTotal(vSalaryBase, cSalaryCommission);
      double cSalaryTotal=sp1.getSalaryTotal();

      System.out.println("Sales $ "+tempAnnualSales+",\tTotal Salary $"+cSalaryTotal+"\t(Base  $"+vSalaryBase+",\tCommission $"+cSalaryCommission+")");
      tempAnnualSales +=5000;
    }
    index++;
    }

    System.out.println();  // Intentional blank line (carriage return)
    System.out.println("Code Finished");  // Indicator Screen Messsage
  }
}




//Additonal Class
class calculations_wk4
{
  private char uiSalesPersonName; // Defines a char variable to hold 'Sales Person Name'
  private int uiSalesPersonId; // Defines an integer variable to hold 'Sales Person Id'
  private BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
  private double cAnnualSalesAdjusted;  // Calculated variable for 'Adjusted Annual Sales' (Annual Sales + 50%)
  private double cSalaryCommission;  // Calculated variable to hold 'Amount of Commission'
  private double cSalaryTotal;  // Calculated variable to hold 'Total Salary'

  private double vCommissionRate;  // Variable to hold 'Rate of Commission'
  private double vCommissionRateAccelerator;  // Varoable to hold 'Commission Rate Accelerator' value
  private double vSalaryBase;  // Variable to hold 'Base Salary'
  private double vSalesTarget;  // Variable to hold 'Target Sales'

  private double uiAnnualSales; // User Input variable for 'Annnual Sales Figure'
  private Scanner uiKeyboard = new Scanner(System.in);  // User Input object to read keyboard input

// Constructor Methods
    public void setAnnualSales(double as)
  {
    uiAnnualSales=as;  // Set value to value passed
  }

  public void setAnnualSalesAdjusted(double as)
  {
    cAnnualSalesAdjusted=(as*1.50);  // Set value to result of value passed + 50%
  }

  public void setCommissionRate(double cr)
  {
    vCommissionRate=cr;  // Set value to value passed
  }

  public void setCommissionRateAccelerator(double cra)
  {
    vCommissionRateAccelerator=cra;  // set value to value passed
  }

  public void setSalaryBase(double sb)
  {
    vSalaryBase=sb;  // Set variable to value passed
  }

  public void setSalaryCommission(double as, double cr, double st, double cra)
  {
    // define IF THEN ELSE logic in here
    if (as<=(st*0.80))
    {
      cSalaryCommission=0.00;
    }
    else if ((as>(st*0.80)) && (as<=st))
    {
      cSalaryCommission=(as*cr);
    }
    else
    {
      cSalaryCommission=((as*cr)+((as-st)*(cr*cra)));
    }
  }

  public void setSalaryTotal(double sb, double sc)
  {
    cSalaryTotal=(sb+sc);  // Set variable to sum of two values passed
  }

  public void setSalesTarget(double st)
  {
    vSalesTarget=st;
  }


// Mutator Methods
    public double getAnnualSales()
  {
    while (uiAnnualSales<=0.00)
    {
      System.out.println("Please enter a dollar amount for the Annual Sales: ");
      uiAnnualSales=uiKeyboard.nextDouble();
    }
    return uiAnnualSales;
  }

  public double getAnnualSalesAdjusted()
  {
    return cAnnualSalesAdjusted;
  }

  public double getCommissionRate()
  {
    return vCommissionRate;
  }

  public double getCommissionRateAccelerator()
  {
    return vCommissionRateAccelerator;
  }

  public double getSalaryBase()
  {
    return vSalaryBase;
  }

  public double getSalaryCommission()
  {
    return cSalaryCommission;
  }

  public double getSalaryTotal()
  {
    return cSalaryTotal;
  }

  public double getSalesTarget()
  {
    return vSalesTarget;
  }

  public double getSalesPersonName()
  {
    return uiSalesPersonName;
  }
}