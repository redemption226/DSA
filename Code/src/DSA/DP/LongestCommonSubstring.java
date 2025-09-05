package DSA.DP;

import java.util.Arrays;


/*
Given two strings, s1 and s2, the task is to find the length of the Longest Common Subsequence. If there is no common subsequence, return 0. A subsequence is a string generated from the original string by deleting 0 or more characters, without changing the relative order of the remaining characters.

For example, subsequences of "ABC" are "", "A", "B", "C", "AB", "AC", "BC" and "ABC". In general, a string of length n has 2n subsequences.

Examples:

Input: s1 = "ABC", s2 = "ACD"
Output: 2
Explanation: The longest subsequence which is present in both strings is "AC".

Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 4
Explanation: The longest common subsequence is "GTAB".

Input: s1 = "ABC", s2 = "CBA"
Output: 1
Explanation: There are three longest common subsequences of length 1, "A", "B" and "C".
 */

public class LongestCommonSubstring {
    public static void main(String[] args) {

        String s1 = "AGGTYAB";
        String s2 = "GXTYXAYB";

        int m = s1.length();
        int n = s2.length();


        //System.out.println(lcs(s1, s2, m - 1, n - 1));

        int dp[][] = new int[m + 1][n + 1];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        System.out.println(lcs(s1, s2, m - 1, n - 1, dp));

        System.out.println(lcsDP(s1, s2, m, n));

    }

    public static int lcs(String s1, String s2, int m, int n) {

        if (n < 0 || m < 0)
            return 0;

        if (s1.charAt(m) == s2.charAt(n))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }

    public static int lcs(String s1, String s2, int m, int n, int[][] dp) {

        if (n < 0 || m < 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (s1.charAt(m) == s2.charAt(n))
            dp[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
        else
            dp[m][n] = 0;

        return dp[m][n];
    }

    public static int lcsDP(String s1, String s2, int m, int n) {

        int[][] dp = new int[m+1][n+1];
        int max = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return max;
    }
}
