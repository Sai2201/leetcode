/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 */

public class SortByParity {

    public int[] sortArrayByParity(int[] array) {
        int end = array.length - 1;
        int start = 0;
        while (start < end) {
            if (array[start] % 2 == 0) {
                start++;
                continue;
            }
            if (array[end] % 2 != 0) {
                end--;
                continue;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }
}
