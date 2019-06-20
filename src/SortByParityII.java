/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 */

public class SortByParityII {

    public int[] sortArrayByParityII(int[] array) {
        int len = array.length;
        int even = 0;
        int odd = 1;

        while ( even < len && odd < len ) {
            if (array[even] % 2 == 0) {
                even += 2;
                continue;
            }

            if ( array[odd] %2 != 0 ){
                odd += 2;
                continue;
            }

            int temp = array[even];
            array[even] = array[odd];
            array[odd] = temp;

        }

        return array;
    }


}
