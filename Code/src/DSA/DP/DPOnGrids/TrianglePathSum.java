package DSA.DP.DPOnGrids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrianglePathSum {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        // int i = 0;
        // int j=0;

        int n = triangle.size();
        //return f(i,j,triangle);

        int[][] dp = new int[n][n];


        for (int j=0; j<n; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for (int i = n-2; i>=0; i--) {
            for (int j = i; j>=0; j--) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
            System.out.println(Arrays.toString(dp[i]));
        }



        return dp[0][0];

    }

    public int f(int i, int j, List<List<Integer>> triangle) {

        if (i == triangle.size()-1)
            return triangle.get(i).get(j);

        return triangle.get(i).get(j) + Math.min(f(i+1, j, triangle) , f(i+1, j+1, triangle));
    }
}
