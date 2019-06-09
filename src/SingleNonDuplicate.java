/**
 * Given a sorted array consisting of only integers where every element appears exactly twice except for one element which appears exactly once.
 * Find this single element that appears only once.
 *
 * Your solution should run in O(log n) time and O(1) space.
 */

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while ( start < end ) {
            int mid = start + (end-start)/2;
            if ( mid % 2 == 1) {
                mid--;
            }
            if ( nums[mid] != nums[mid+1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }
        return nums[start];
    }

}
