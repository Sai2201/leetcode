/**
 * Given a string, find its rank among all its permutations sorted lexicographically.
 * For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6.
 */
public class LexographicRank {

    /**
     * Return the lexographic rank of a string
     */
    protected int lexoRank ( String str ) {

        int len = str.length();

        int total = fact ( len );

        int rank = 1;

        for ( int ind = 0; ind < len; ind ++ ) {
            char ch = str.charAt( ind );
            total = total / ( len - ind );
            // Add ranks of all preceding strings.
            rank += countRight( ch, str, ind ) * ( total );
        }
        return rank;
    }


    /**
     * Count characters to the right of the current character which are lesser in rank.
     */
    private int countRight(char ch, String str, int ind) {
        int count = 0;
        for ( int start = ind+1; start<str.length(); start++) {
            if ( ch > str.charAt(start) ) {
                count++;
            }
        }
        return count;
    }


    private int fact ( int number ) {
        int[] dp = new int[number+1];
        dp[0] = 1;
        for ( int index = 1; index <= number; index++ ) {
            dp[index] = dp[index-1] * index;
        }
        return dp[number];
    }
}
