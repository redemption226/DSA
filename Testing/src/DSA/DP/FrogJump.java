package DSA.DP;//
//Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the top.
//
//Example:
//
//Input: heights[] = [20, 30, 40, 20]
//Output: 20
//Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
//jump from stair 0 to 1: cost = |30 - 20| = 10
//jump from stair 1 to 3: cost = |20-30|  = 10
//Total Cost = 10 + 10 = 20
//Input: heights[] = [30, 20, 50, 10, 40]
//Output: 30
//Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
//jump from stair 0 to 2: cost = |50 - 30| = 20
//jump from stair 2 to 4: cost = |40-50|  = 10
//Total Cost = 20 + 10 = 30

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {

        int[] heights = {30, 20, 50, 10, 40};
        int n = heights.length;
        int dp[] = new int[n+1];
        dp[0] = 0;

        System.out.println(frogJumpDP(heights, n-1, dp));


    }

    public static int frogJumpDP(int[] heights, int n, int[] dp) {

        for (int i=1; i<=n; i++) {
            int secondStep =Integer.MAX_VALUE ;
            int oneStep = Math.abs(heights[i] - heights[i-1]) + dp[i-1];
            if (i > 1)
                secondStep = Math.abs(heights[i] - heights[i-2]) + dp[i-2];

            dp[i] = Math.min(oneStep, secondStep);
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];


    }

    public static int frogJump(int[] heights, int n, int[] dp) {

        if (dp[n] != 0)
            return dp[n];

        if (n == 0) {
            return 0;
        }

        int secondStep =0 ;
        int oneStep = Math.abs(heights[n] - heights[n-1]) + frogJump(heights, n-1, dp);
        if (n > 1)
            secondStep = Math.abs(heights[n] - heights[n-2]) + frogJump(heights, n-2, dp);

        int min = Math.min(oneStep, secondStep);
        dp[n] = min;

        return dp[n];
    }
}
