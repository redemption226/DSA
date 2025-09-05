package DSA.DP;

public class Knapsack01 {


    /*
    Given two integer arrays, val and wt, each of size N, which represent the values and
    weights of N items respectively, and an integer W representing the maximum capacity of a knapsack,
     determine the maximum value achievable by selecting a subset of the items such that the total weight of the
     selected items does not exceed the knapsack capacity W.



Each item can either be picked in its entirety or not picked at all (0-1 property). The goal is to
maximize the sum of the values of the selected items while keeping the total weight within the knapsack's capacity.

Examples:
Input: val = [60, 100, 120], wt = [10, 20, 30], W = 50

Output: 220

Explanation: Select items with weights 20 and 30 for a total value of 100 + 120 = 220.

Input: val = [10, 40, 30, 50], wt = [5, 4, 6, 3], W = 10

Output: 90

Explanation: Select items with weights 4 and 3 for a total value of 40 + 50 = 90.

     */



    public static void main(String[] args) {

        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        int W = 7;

        int n = val.length;

        System.out.println(maximizeProfit(val, wt, n-1, W));



        // Space Optimised DP
        int[] prev = new int[W + 1];
        prev[0] = 0;
        if (wt[0] <=W)
            prev[wt[0]] = val[0];

        for (int i=1; i<n; i++) {
            int[] curr = new int[W + 1];
            for (int j = 0; j <= W; j++) {

                int pick = 0;
                int notPick = prev[j];

                if (wt[i] <= j) {
                    pick = val[i] + prev[j - wt[i]];
                }

                curr[j] = Math.max(pick, notPick);
            }
            prev= curr;
        }

        System.out.println(prev[W]);


        // DP DSA.DP.Solution
        int[][] dp = new int[n][W+1];

        for (int i=0; i<n;i++) {
            dp[i][0] = 0;
        }

        if (W-wt[0] >= 0)
            dp[0][wt[0]] = val[0];

        for (int i=1; i<n; i++) {
            for (int j = 0; j <= W; j++) {

                int pick = 0;
                int notPick = dp[i - 1][j];

                if (wt[i] <= j) {
                    pick = val[i] + dp[i - 1][j - wt[i]];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }
        System.out.println(dp[n-1][W]);
    }

    public static int maximizeProfit(int[] val, int[] wt, int n, int W) {

        if (W < 0)
            return 0;

        if (n==0) {
            if (W - wt[0] >= 0)
                return val[0];
            else return 0;
        }

        int pick = 0;

        int notPick = maximizeProfit(val, wt,n-1, W);

        if(wt[n] <= W)
            pick = val[n] + maximizeProfit(val, wt,n-1, W-wt[n] );

        return Math.max(pick,notPick);

    }
}
