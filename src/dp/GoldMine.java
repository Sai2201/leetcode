package dp;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell,
 * the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Find out maximum amount of gold he can collect.
 *
 * Input : mat[][] = {{1, 3, 3},
 *                    {2, 1, 4},
 *                   {0, 6, 4}};
 * Output : 12
 * {(1,0)->(2,1)->(2,2)}
 */

public class GoldMine {

    public int maxGoldAmount ( int[][] gold ) {

        if ( gold == null || gold.length < 1 ) {
            return -1;
        }


        int row = gold.length;
        int column = gold[0].length;

        int[][] maxGold = new int[row][column];
        int rightUp =0, right = 0, rightDown = 0;

        // Start from last column and backtrack the path.
        for ( int col = column-1;col >= 0; col-- ) {
            for ( int ini = 0; ini < row; ini++ ) {
                rightUp =  (col == column - 1 || ini == 0 ) ? 0 : maxGold[ini-1][col+1];
                right = ( col == column - 1 ) ? 0 : maxGold[ini][col+1];
                rightDown = ( col == column - 1 || ini == row - 1 ) ? 0 : maxGold[ini+1][col+1];

                maxGold[ini][col] = gold[ini][col] + Math.max ( right, Math.max( rightDown, rightUp ) );
            }
        }

        int result = maxGold[0][0];
        for ( int ind = 1;ind<row; ind++ ) {
            result = Math.max ( result, maxGold[ind][0]);
        }

        return result;

    }

}
