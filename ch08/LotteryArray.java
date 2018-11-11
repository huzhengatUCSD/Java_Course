package ch08;

import java.util.Arrays;

/**
 * This program demonstrates a triangular array.
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class LotteryArray
{
   public static void main(String[] args)
   {
      final int NMAX = 10;

      // allocate triangular array
      int[][] odds = new int[NMAX + 1][];
      for (int n = 0; n <= NMAX; n++)
         odds[n] = new int[n + 1];

      // fill triangular array
      for (int n = 0; n < odds.length; n++)
         for (int k = 0; k < odds[n].length; k++)
         {
            /*
             * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
             */
            int lotteryOdds = 1;
            for (int i = 1; i <= k; i++)
               lotteryOdds = lotteryOdds * (n - i + 1) / i;

            odds[n][k] = lotteryOdds;
         }

      // print triangular array
      for (int i=0;i<odds.length;i++)
      {
          for(int pad=odds.length-i; pad>0; pad--)
        	  System.out.print("  ");
    	  for (int j=0;j<odds[i].length;j++)
            System.out.printf("%4d", odds[i][j]);
         System.out.println();
      }
      //System.out.println(Arrays.deepToString(odds));
   }
}
