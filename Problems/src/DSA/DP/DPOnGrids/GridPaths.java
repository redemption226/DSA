package DSA.DP.DPOnGrids;

public class GridPaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {

        //Recursion
        //return findTotalPath(m-1,n-1);


        //Memo
        int[][] dp = new int[m+1][n+1];

        // for (int i = 0; i< m; i++) {
        //     for (int j=0; j<n; j++ )
        //         dp[i][j] = -1;
        // }

        // return findTotalPathMemo(m-1,n-1, dp);


        //DP
        for (int i=0; i< m; i++) {
            dp[i][0] = 1;
        }
        for (int j=0; j< n; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static int findTotalPath(int m, int n) {


        if (m<0 || n < 0)
            return 0;

        if (m == 0 && n==0 )
            return 1;

        return findTotalPath(m, n-1) + findTotalPath(m-1, n);
    }

    public static int findTotalPathMemo(int m, int n, int[][] dp) {

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
