package DSA.DP;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i<n; i++) {
            int take = prev2 + nums[i];
            int notTake = 0 + prev;
            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;

        //return f(nums, n-1);
        // int[] dp = new int[n];

        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for (int i = 2; i<n; i++) {
        //     dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        // }

        // return dp[n-1];

    }

    public int f(int[] nums, int n) {

        if (n == 0)
            return nums[0];

        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }

        int pick = nums[n] + f (nums, n-2);

        int notPick = 0 + f(nums, n-1);

        return Math.max(pick, notPick);
    }
}
