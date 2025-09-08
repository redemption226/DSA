package DSA.DP;

public class MaximalSquare {

    public static void main(String[] args) {

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(maximalSquare(matrix));
    }
        public static int maximalSquare(char[][] matrix) {

            int n = matrix.length;
            int m = matrix[0].length;

            int max = 0;
            int dp[][] = new int[n][m];

            for (int i = 0; i<n; i++) {
                dp[i][m-1] = matrix[i][m-1] - '0';
                max = Math.max(max, dp[i][m-1]);
            }

            for (int j = 0; j<m; j++) {
                dp[n-1][j] = matrix[n-1][j] - '0';
                max = Math.max(max, dp[n-1][j]);
            }

            for (int i=n-2; i>=0; i--) {
                for (int j=m-2; j>=0; j--) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            return max*max;
        }
}
