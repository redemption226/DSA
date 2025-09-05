package DSA.DP;/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the
 elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

        int[] nums = {1,2,3,5};

        int total=0;

        for (int x: nums) {
            total+=x;
        }

        if (total%2 != 0) {
            System.out.println(false);
            return;
        }
        else
            System.out.println(f(nums, total/2, nums.length-1));

        int n = nums.length;
        int target = total/2;

        boolean[][] dp = new boolean[n][target+1];

        for (int i=0; i<n; i++)
            dp[i][0] = true;

        // Also, for the first element the value is true if it is less than the target, for the base case;
        if (nums[0] <= target)
            dp[0][nums[0]] = true;

        for (int i=1; i<n; i++) {
            for (int sum = 1; sum <= target; sum++) {

                boolean pick = false;
                if (nums[i] <= sum)
                    pick = dp[i-1][sum-nums[i]];
                boolean notPick = dp[i-1][sum];

                dp[i][sum] = pick || notPick;
            }
        }

        System.out.println(dp[n-1][target]);
    }

    public static boolean f(int[] arr, int sum, int n) {

        if (n==0 && sum > 0)
            return false;

        if (n==0 && arr[n] == sum)
            return true;

        if (sum == 0)
            return true;

        boolean pick =false;
        if (arr[n] <= sum)
            pick = f(arr, sum-arr[n], n-1);
        boolean not_pick = f(arr, sum, n-1);

        return pick || not_pick;
    }

}
