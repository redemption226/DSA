package DSA.DP;
/*
Given an array arr[] of non-negative integers and a value sum, the task is to check if there is a subset of the given array whose sum is equal to the given sum.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: False
Explanation: There is no subset that add up to 30.
 */

public class TargetSum {

    public static void main(String[] args) {
       int[] arr =  {3, 34, 4, 12, 5, 2}; int  sum = 9;
        //System.out.println(targetSum(arr, sum));

        //DP

        boolean[][] dp = new boolean[arr.length][sum+1];


        // Initialize the first row of the DP table
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i=1; i< arr.length; i++) {
            for (int target=1; target<=sum; target++) {
                if (target == 0)
                    dp[i][target] = true;

                boolean taken = false;
                if (arr[i] <= target) {
                    taken = dp[i-1][target-arr[i]];
                }

                boolean notTaken = dp[i-1][target];

                dp[i][target] = taken || notTaken;
            }
        }

        System.out.println(dp[arr.length-1][sum]);

    }

    public static boolean targetSum(int[] arr, int sum) {

        int n = arr.length;
        return f(arr, sum, n-1);
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
