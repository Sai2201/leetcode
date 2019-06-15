/**
 * Find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */

import java.util.Arrays;

public class LIS {

    protected int calculateLIS ( int[] array ) {
        int len = array.length;
        int[] lis = new int[len];
        Arrays.fill(lis,1);
        for ( int index1=1;index1<len;index1++ ) {
            int backIndex = index1-1;
            while ( backIndex >=0 ) {
                if ( array[backIndex] < array[index1] && lis[index1] < (lis[backIndex] + 1 ) ) {
                    lis[index1] = lis[backIndex] + 1;
                }
                backIndex--;
            }
        }
        return lis[len-1];
    }
}
