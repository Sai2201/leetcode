import java.util.Arrays;

/**
 *  Students are asked to stand in non-decreasing order of heights for an annual photo.
 *  Return the minimum number of students not standing in the right positions.
 *  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 *  Input: [1,1,4,2,1,3]
 *  Output: 3
 *  Explanation:
 *  Students with heights 4, 3 and the last 1 are not standing in the right positions.
 */

public class HeightChecker {

    /**
     * Straight sort, copy array solution O(nlgn)
     */
    public int heightChecker( int[] heights ){
        int len = heights.length;
        int count = 0;

        int[] dupliArray = heights.clone();

        Arrays.sort(dupliArray);
        int index =0;
        while ( index < heights.length ) {
            if ( heights[index] != dupliArray[index]) {
                count++;
            }
            index++;
        }
        return count;
    }


    /**
     * Using a counter array O(n)
     */
    public int heightCheckerEfficient ( int[] heights ) {
        int max = max ( heights);
        int[] counter = new int[max+1];
        int index = 1;

        for ( int val : heights ) {
            counter[val]++;
        }

        int numberOfElements = 0;
        for ( int height : heights ) {
            while (counter[index] <= 0 ) {
                index++;
            }
            if ( index != height ) {
                numberOfElements++;
            }
            counter[index]--;
        }
        return numberOfElements;
    }

    private int max ( int[] array ) {
        int max = Integer.MIN_VALUE;
        for ( int val : array ) {
            if ( max < val ) {
                max = val;
            }
        }
        return max;
    }
}
