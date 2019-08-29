package dp;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * Example:
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {

    //recursive check sum
    public boolean checkSubsetSum ( int[] set, int sum, int n ) {

        if ( sum == 0 ) {
            return true;
        }

        if ( sum >0 && n == 0) {
            return false;
        }

        if ( set[n-1] > sum ) {
            return checkSubsetSum( set, sum, n-1);
        }

        return checkSubsetSum( set, sum, n-1) || checkSubsetSum( set, sum-set[n-1], n-1);

    }


    // Iterative
    public boolean iterativeSubsetSum ( int[] set, int sum, int n ) {

        boolean[][] dp = new boolean[sum+1][n+1];

        // when sum is zero.
        for ( int ind = 0; ind<=n;ind++ ) {
            dp[0][ind] = true;
        }

        // base case : when indices are 0.
        for ( int val = 0;val <= sum ; val++ ) {
            dp[val][0] = false;
        }

        for ( int val =1;val<=sum;val++ ) {
            for ( int ind = 1;ind<=n;ind++ ) {
                //exclude the array number at index
                dp[val][ind] = dp[val][ind-1];
                //include the array number at index, if it's total is less that current sum (val)
                if ( val-set[ind-1] >= 0 ) {
                    dp[val][ind] = dp[val][ind] || dp[val-set[ind-1]][ind-1];
                }
            }
        }

        return dp[sum][n];
    }


}
