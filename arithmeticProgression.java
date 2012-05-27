package prg_420;

/**
 *
 * @author Dave
 */
public class arithmeticProgression
{
  public static void main(String[] args)
  {
    System.out.println("Program Starting");
    System.out.println();
    System.out.println("Starting 'For' loop");
    int sum = 0;
    for (int i = 1; i <= 1000; i++)
    {
      sum += i;
      System.out.println(Integer.toString(sum));
    }
    System.out.println();
    System.out.println("Starting 'While' loop");
    int sum2 = 0;
    int y = 1;
    while (y <=1000)
    {
      sum2 += y;
      System.out.println(Integer.toString(sum2));
      y++;
    }
    System.out.println();
    System.out.println("Program finished");
  }
}