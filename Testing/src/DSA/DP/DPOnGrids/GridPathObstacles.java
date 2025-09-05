package DSA.DP.DPOnGrids;

public class GridPathObstacles {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Recursion
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // if (obstacleGrid[0][0] == 1) return 0;

        // return findTotalPath(m-1,n-1,obstacleGrid);


        //Memo
        int[][] dp = new int[m+1][n+1];

        // // for (int i = 0; i< m; i++) {
        // //     for (int j=0; j<n; j++ )
        // //         dp[i][j] = -1;
        // // }

        // // return findTotalPathMemo(m-1,n-1, dp);

        // if (obstacleGrid[0][0] == 1)
        //     return 0;

        //DP

        for (int i=0; i< m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int j=0; j< n; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i][j-1] + dp[i-1][j] : 0;
            }
        }

        return dp[m-1][n-1];
    }

    public int findTotalPath(int m, int n, int[][] obstacleGrid) {


        if (m<0 || n < 0)
            return 0;

        if (m == 0 && n==0 )
            return 1;

        return obstacleGrid[m][n] == 0 ? (findTotalPath(m, n-1,obstacleGrid) + findTotalPath(m-1, n,obstacleGrid)) : 0;
    }

    public int findTotalPathMemo(int m, int n, int[][] dp) {

        if (m<0 || n < 0) {
            return 0;
        }

        if (dp[m][n] != -1)
            return dp[m][n];

        if (m == 0 && n==0 ) {
            dp[m][n] = 1;
            return 1;
        }

        dp[m][n] =  findTotalPathMemo(m, n-1, dp) + findTotalPathMemo(m-1, n, dp);
        return dp[m][n];
    }
}
