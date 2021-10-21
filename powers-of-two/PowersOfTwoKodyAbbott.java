// This program should compute and output all of the "powers of two" from 2 to the 0th power, 
// up through 2 to the 10th power.  Your output should look like the following:
// 2 to the 0 power is: 1.0
// 2 to the 1 power is: 2.0
// 2 to the 2 power is: 4.0
// 2 to the 3 power is: 8.0
// etc. all the way to 10th power.

package powers.of.two.kody.abbott;

public class PowersOfTwoKodyAbbott
{
    public static void main(String[] args)
    {
        for (int i = 0; i <= 10; i++)
        {
            System.out.println("2 to the " + i + " power is: " + Math.pow(2, i));
        }
    }
}
