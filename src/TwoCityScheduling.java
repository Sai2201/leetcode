import java.util.*;

/**
 * There are 2N people a company is planning to interview.
 * The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
public class TwoCityScheduling {

    public int twoCitySchedulingCost ( int[][] costs ) {

        int row = costs.length;

        Arrays.sort(costs, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ( o1[0]- o1[1] ) - ( o2[0] - o2[1] );
            }
        });

        //minimum cost required
        int totalCost = 0;

        int index = 0;
        while ( index < row/2 ) {
            totalCost += costs[index][0];
            index++;
        }

        while ( index < row ) {
            totalCost += costs[index][1];
            index++;
        }

        return totalCost;
    }

}
