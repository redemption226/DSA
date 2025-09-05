package DSA.DP;
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

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int m = s1.length();
        int n = s2.length();


        System.out.println(lcs(s1, s2, m - 1, n - 1));

        int dp[][] = new int[m + 1][n + 1];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        System.out.println(lcs(s1, s2, m - 1, n - 1, dp));

        int printDP[][] = new int[m + 1][n + 1];

        System.out.println(lcsDP(s1, s2, m, n, printDP));
        System.out.println(lcsDPOpti(s1, s2, m, n));
        System.out.println(lcsDPOpti2(s1, s2, m, n));

        printLCS(printDP, s1, s2);



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
            dp[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));

        return dp[m][n];
    }

    public static int lcsDP(String s1, String s2, int m, int n, int[][] dp) {

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return dp[m][n];
    }

    public static int lcsDPOpti(String s1, String s2, int m, int n) {

        int[] prev = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[n];
    }

    public static int lcsDPOpti2(String s1, String s2, int m, int n) {

        int[] prev = new int[n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    prev[j] = 1 + prev[j - 1];
                else
                    prev[j] = Math.max(prev[j], prev[j - 1]);
            }
        }
        return prev[n];
    }

    public static void printLCS(int[][] dp, String s1, String s2) {
        int m = dp.length - 1;
        int n = dp[0].length - 1;

        StringBuilder sb = new StringBuilder();

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(sb.reverse().toString());
    }
}
