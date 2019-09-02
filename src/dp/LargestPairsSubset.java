package dp;

import java.util.Arrays;

/**
 * Given an array of n distinct elements, find length of the largest subset such that every pair in the subset is such that the larger element of the pair is divisible by smaller element.
 *
 * Examples:
 *
 * Input : arr[] = {10, 5, 3, 15, 20}
 * Output : 3
 * Explanation: The largest subset is 10, 5, 20. 10 is divisible by 5, and 20 is divisible by 10.
 */
public class LargestPairsSubset {

    public int largestDivisiblePairSubset ( int[] array ) {

        if ( array == null || array.length < 1 ) {
            return 0;
        }

        int len = array.length;
        Arrays.sort ( array );

        // Store the largest divisible subset beginning with array[index]
        int[] dp = new int[len];
        // Last element is largest
        dp[len-1] = 1;

        for ( int ind = len-2;ind>=0;ind-- ) {
            int maximum = 0;
            for ( int div = ind+1; div<len; div++ ) {
                // find max length of divisible values.
                if ( array[div] % array[ind] == 0 ) {
                    maximum = Math.max(maximum, dp[div]);
                }
            }

            dp[ind] = 1 + maximum;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
