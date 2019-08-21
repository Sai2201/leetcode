package dp;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {

   // Recursive
    public int recursiveCoinChange ( int[] coins , int value ) {
        return recurCoinChange ( coins, coins.length, value );
    }

    public int recurCoinChange ( int[] coins, int size, int value ) {
        if ( value < 0 ) {
            return 0;
        }

        if ( value == 0 ) {
            return 1;
        }

        if ( size <=0 && value >=0 ) {
            return 0;
        }

        // No. of ways excluding the last coin + including the last coin
        return recurCoinChange(coins, size-1, value) + recurCoinChange(coins,size, value-coins[size-1]);
    }


    //Iterative
    public int iterativeCoinChange ( int[] coins , int value ) {

        if ( coins == null || value < 0 ) {
            return 0;
        }
        if ( value == 0 ) {
            return 1;
        }

        int size = coins.length;
        int[][] dp = new int[value+1][size];
        Arrays.fill( dp[0], 1);


        for ( int ind = 1; ind<=value; ind++) {
            for( int coi = 0; coi<size;coi++) {
                int including = ( ind - coins[coi] >= 0) ? dp[ind-coins[coi]][coi] : 0;
                int excluding = ( coi - 1 >= 0) ? dp[ind][coi-1] : 0;

                dp[ind][coi] = including + excluding;
            }
        }

        return dp[value][size-1];
    }
}