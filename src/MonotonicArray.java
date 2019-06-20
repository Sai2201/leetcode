/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 */

public class MonotonicArray {

    public boolean isMonotonic(int[] array) {
        int len = array.length;
        if (len == 1) {
            return true;
        }
        // set to true if Monotonically increasing
        boolean monoIncreasing = false;
        // set to true, once the monotonicity is defined.
        boolean defined = false;

        int index;
        for (index = 1; index < len; index++) {
            if (array[index] == array[index - 1]) {
                continue;
            }
            if (defined && monoIncreasing && (array[index] < array[index - 1])) {
                return false;
            }
            if (defined && !monoIncreasing && (array[index] > array[index - 1])) {
                return false;
            }

            if (!defined) {
                defined = true;
                monoIncreasing = (array[index] > array[index - 1]);
            }


        }

        return (index == len);
    }
}
