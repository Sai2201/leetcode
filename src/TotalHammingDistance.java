/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * Input: 4, 14, 2
 *
 * Output: 6
 */

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        //hold the total hamming distance
        int hammingDistance = 0;

       for ( int ind = 0; ind<32; ind++ ) {
           // store the number of ones at each position
           int ones = 0;
           int zeros = 0;
           int mask = 1<<ind;
           for ( int num : nums ) {
               if ( (num & mask) != 0 ) {
                   ones++;
               } else {
                   zeros++;
               }
           }
           // all possible combinations of no-conflict for each pair.
           hammingDistance += (ones * zeros);
       }

       return hammingDistance;
    }
}
