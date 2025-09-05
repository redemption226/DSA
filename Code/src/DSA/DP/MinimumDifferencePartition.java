package DSA.DP;

/**
 Problem statement
 You are given an array 'arr' containing 'n' non-negative integers.



 Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.



 You just need to find the minimum absolute difference considering any valid division of the array elements.



 Note:

 1. Each array element should belong to exactly one of the subsets.

 2. Subsets need not always be contiguous.
 For example, for the array : [1, 2, 3], some of the possible divisions are
 a) {1,2} and {3}
 b) {1,3} and {2}.

 3. Subset-sum is the sum of all the elements in that subset.
 Example:
 Input: 'n' = 5, 'arr' = [3, 1, 5, 2, 8].

 Ouput: 1

 Explanation: We can partition the given array into {3, 1, 5} and {2, 8}.
 This will give us the minimum possible absolute difference i.e. (10 - 9 = 1).
 Detailed explanation ( Input/output format, Notes, Images )
 Sample Input 1:
 4
 1 2 3 4
 Sample Output 1:
 0
 Explanation for sample input 1:
 We can partition the given array into {2,3} and {1,4}.
 This will give us the minimum possible absolute difference i.e. (5 - 5 = 0) in this case.
 Sample Input 2:
 3
 8 6 5
 Sample Output 2:
 3
 Explanation for sample input 2:
 We can partition the given array into {8} and {6,5}.
 This will give us the minimum possible absolute difference i.e. (11 - 8 = 3).
 Expected time complexity:
 The expected time complexity is O(n * 𝚺 'arr'[i]), where 𝚺 'arr'[i] denotes the sum of all elements in 'arr'.
 Constraints:
 1 <= 'n' <= 10^3
 0 <= 'arr'[i] <= 10^3
 0 <= 𝚺 'arr'[i] <= 10^4,

 where 𝚺 'arr'[i] denotes the sum of all elements in 'arr'.

 */


public class MinimumDifferencePartition {

    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 2, 8};

        int n = arr.length;
        int total = 0;

        for (int x : arr)
            total+=x;

        System.out.println(getMinDifference(arr, 0,total, n-1));

        boolean[][] dp = new boolean[n+1][total+1];

        for (int i=0; i<=n; i++)
            dp[i][0] = true;

        // Also, for the first element the value is true if it is less than the target, for the base case;
        if (arr[0] <= total)
            dp[0][arr[0]] = true;

        for (int i=1; i<=n; i++) {
            for (int sumTillNow = 1; sumTillNow<=total; sumTillNow++) {
                boolean take=false;
                if (sumTillNow >= arr[i-1])
                    take = dp[i-1][sumTillNow-arr[i-1]];
                boolean notTake = dp[i-1][sumTillNow];
                dp[i][sumTillNow] = take || notTake;
            }
        }

        // Find the subset sum closest to total/2
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= total / 2; s1++) {
            if (dp[n][s1]) {
                int s2 = total - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }

        System.out.println(minDiff);


    }

    public static int getMinDifference(int[] arr, int sumTillNow, int total, int n) {

        if (n==0) {
            return Math.abs((total-sumTillNow) - sumTillNow);
        }

        int take = getMinDifference(arr, sumTillNow+arr[n], total, n-1);
        int notTake = getMinDifference(arr, sumTillNow, total, n-1);

        return Math.min(take,notTake);

    }
}
