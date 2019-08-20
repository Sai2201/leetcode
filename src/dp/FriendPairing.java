package dp;

/**
 * Given n friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
 */
public class FriendPairing {

    public int friendPair ( int numberOfFriends ) {

        int[] dp = new int[numberOfFriends+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for ( int index =3;index<=numberOfFriends;index++ ) {
            // nth person - Either single or paired with one of the remaining index-1 people.
            dp[index] = dp[index-1] + (index - 1) * dp[index-2];
        }

        return dp[numberOfFriends];
    }
}
