package DSA.DP.DPOnGrids;

public class MinimumFallingSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println(minFallingPathSum(matrix));
    }
    public static int minFallingPathSum(int[][] matrix) {

        // int min = Integer.MAX_VALUE;

        // for (int j=0; j<matrix.length; j++)
        //     min = Math.min(min, f(0,j, matrix));

        // return min;

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int column=0; column < n; column++)
            dp[n-1][column] = matrix[n-1][column];


        for (int i = n-2; i>= 0; i--) {
            for (int j=n-1; j>=0; j--) {
                int dl = Integer.MAX_VALUE;
                int dr = Integer.MAX_VALUE;
                if (j>0)
                    dl = dp[i+1][j-1];
                if (j<n-1)
                    dr = dp[i+1][ j+1];
                int down = dp[i+1][ j];


                dp[i][j] = matrix[i][j] + Math.min( Math.min(dl, down), dr);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int column=0; column < n; column++)
            min = Math.min(min, dp[0][column]);

        return min;



    }

    public int f(int i,int j, int[][] matrix ) {

        if (j <0 || j>= matrix.length)
            return Integer.MAX_VALUE;

        if (i == matrix.length -1)
            return matrix[i][j];



        return matrix[i][j] + Math.min( Math.min(f(i+1, j-1, matrix), f(i+1, j, matrix)), f(i+1, j+1, matrix));
    }
}
