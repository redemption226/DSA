package DSA.DP;/*
Given an array arr[] of size n, the task is to find the length of the Longest Increasing Subsequence (DSA.DP.LIS) i.e.,
the longest possible subsequence in which the elements of the subsequence are sorted in increasing order.

Examples:

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest increasing subsequence is 3, 10, 20

Input: arr[] = [30, 20, 10]
Output:1
Explanation: The longest increasing subsequences are [30], [20] and [10]

Input: arr[] = [2, 2, 2]
Output: 1
Explanation:  We consider only strictly increasing.

Input: arr[] = [10, 20, 35, 80]
Output: 4
Explanation: The whole array is sorted


 */

import java.util.*;

public class LIS {
    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        int n = arr.length;
        int idx = -1;
        int i = 0;

        System.out.println(f(arr,n , i,idx));

        Integer[][] dp = new Integer[n][n+1];
        System.out.println(f(arr,n , i,idx, dp));

        System.out.println(fDP(arr,n));

        System.out.println(fDP2(arr,n));

        System.out.println(printLIS(arr,n));

        System.out.println(LISBinarySearch(arr,n));

    }

    public static int f(int[] arr, int n, int i, int lastIndex) {

        if (i==n)
            return 0;

        int take = 0 ;
        if (lastIndex == -1 || arr[i] > arr[lastIndex])
            take =  1 + f(arr, n, i+1, i) ;
        int notTake =  f(arr, n, i+1, lastIndex);

        return Math.max(take, notTake);

    }

    public static int f(int[] arr, int n, int i, int lastIndex, Integer[][] dp) {

        if (i==n)
            return 0;

        if (dp[i][lastIndex+1] != null) return dp[i][lastIndex+1];

        int take = 0 ;
        if (lastIndex == -1 || arr[i] > arr[lastIndex])
            take =  1 + f(arr, n, i+1, i) ;
        int notTake =  f(arr, n, i+1, lastIndex);

        return dp[i][lastIndex+1] = Math.max(take, notTake);

    }

    public static int fDP(int[] arr, int n){
        int[][] dp = new int[n+1][n+1];
        for (int i=n-1; i>=0; i--) {
            for (int j=i-1; j>=-1; j--) {
                int take = 0 ;
                if (j == -1 || arr[i] > arr[j])
                    take =  1 + dp[i+1][i+1];
                int notTake =  dp[i+1][j+1];

                dp[i][j+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public static int fDP2(int[] arr, int n){
        int[] dp = new int[n];
        int max=1;

        for (int i =0; i<n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j =0; j<= i-1; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, 1 + dp[j]);
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static String printLIS(int[] arr, int n){
        int[] dp = new int[n];
        int[] hash = new int[n];
        int max=1;
        int lastUpdated = 0;

        for (int i =0; i<n; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j =0; j<= i-1; j++) {
                if (arr[j] < arr[i] && (1 + dp[j]) > max) {
                    max = Math.max(max, 1 + dp[j]);
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    hash[i] = j;
                    lastUpdated = i;
                }
            }
        }

        System.out.println(Arrays.toString(hash));

        List<Integer> ls = new ArrayList<>();
        ls.add(arr[lastUpdated]);
        while (hash[lastUpdated] != lastUpdated) {
            lastUpdated = hash[lastUpdated];
            ls.add(arr[lastUpdated]);
        }

        Collections.reverse(ls);
        return Arrays.toString(ls.toArray());
    }

    public static int LISBinarySearch(int[] arr, int n){

        /*
            Behavior of Collections.binarySearch(list, key):

            If the key is found → it returns the index (0-based) where the key exists.

            If the key is NOT found → it returns
            -(insertionPoint) - 1

            where
            👉 insertionPoint = the index at which the key would need to be inserted to keep the list sorted.
         */

        List<Integer> ls = new ArrayList<>();
        ls.add(arr[0]);

        for (int i=1; i<n; i++) {
            int idx = Collections.binarySearch(ls, arr[i]); // This returns -(insertionPoint -1)
            if (idx < 0) { // Means item not found and we need to insert
                int insertionPoint  = -(idx+1);

                if (ls.size() == insertionPoint)
                    ls.add(arr[i]);
                else
                    ls.set(insertionPoint, arr[i]);
            }
        }

        return ls.size();
    }
}
