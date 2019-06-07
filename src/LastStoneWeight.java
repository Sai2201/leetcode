/**

 We have a collection of rocks, each rock has a positive integer weight.

 Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

 If x == y, both stones are totally destroyed;
 If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 */

import java.util.Arrays;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        int index = stones.length-1;
        while ( index > 0 ) {
            Arrays.sort(stones);
            stones[index - 1] = stones[index] - stones[index - 1];
            index--;
        }
        return stones[0];

    }
}
