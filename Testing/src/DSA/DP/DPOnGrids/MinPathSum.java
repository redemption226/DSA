package DSA.DP.DPOnGrids;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //return minPathSum(m-1,n-1,grid);
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        int sum = dp[0][0];
        for (int i=1; i<m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        sum = dp[0][0];
        for (int j=1; j<n; j++) {
            sum += grid[0][j];
            dp[0][j] = sum;
        }

        for (int i=1; i<m; i++) {
            for (int j = 1; j<n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[m-1][n-1];



    }

    public int minPathSum(int m, int n, int[][] grid) {


        if (m<0 || n < 0)
            return Integer.MAX_VALUE;

        if (m == 0 && n==0 )
            return grid[0][0];

        return grid[m][n] + Math.min (minPathSum(m, n-1, grid), minPathSum(m-1, n, grid));
    }
}
