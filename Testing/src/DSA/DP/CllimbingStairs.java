package DSA.DP;

public class CllimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

        public static int climbStairs(int n) {

            // if (n==2 || n==1)
            //     return n;

            // return climbStairs(n-1) + climbStairs(n-2);

            if (n==2 || n==1)
                return n;

            // int[] dp = new int[n+1];
            // dp[0] = 0;
            // dp[1] = 1;
            // dp[2] = 2;

            // for (int i = 3; i<=n; i++) {
            //     dp[i] = dp[i-1] + dp[i-2];
            // }
            // return dp[n];

            int prev = 1;
            int next = 2;
            for (int i = 3; i<=n; i++) {
                int temp = prev+ next;
                prev=  next;
                next = temp;
            }

            return next;

        }
}
