package DSA.DP;

public class MinCostTickets {
    //TODO Bottom UP

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days,costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int m = costs.length;
        int[] pass = {1,7,30};
        int[] dp = new int[n];
        return mincostTickets(days, costs, n,m,0,pass,dp);

    }

    public static int mincostTickets(int[] days, int[] costs, int n, int m, int i, int[] pass, int[] dp) {

        if (i==n) {
            return 0;
        }

        if (dp[i] != 0)
            return dp[i];

        int min = Integer.MAX_VALUE;

        int j=i;
        for (int k=0; k<m; k++) {

            while (j < n && days[j] < days[i] + pass[k]) {
                j++;

            }
            int res = costs[k] + mincostTickets(days, costs, n,m,j,pass, dp);
            min = Math.min(min, res);
            dp[i] = min;
        }
        return dp[i];
    }
}

