package DSA.DP;

import java.util.Arrays;

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        Solution sol = new Solution();

       String  str1 ="abac";
        String str2 ="cab";

        String s = sol.shortestCommonSupersequence(str1, str2);
        System.out.println(s);
    }
}

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n =str2.length();

        //f(str1, str2, m-1, n-1);

        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            for (int j=1;j<=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] =  1 + dp[ i-1][ j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i][ j-1], dp[i-1][j]);

            }
        }

        for (int[] row: dp ) {
            System.out.println(Arrays.toString(row));

        }


        StringBuffer sb = new StringBuffer();

        int i = m;
        int j = n;


        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--; j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                sb.append(str1.charAt(i-1));
                i--;
            }
            else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }


        while (i>0) {
            sb.append(str1.charAt(i-1)); i--;
        }

        while (j>0){
            sb.append(str2.charAt(j-1)); j--;
        }


        return sb.reverse().toString();

    }

    // public int f(String str1, String str2, int i, int j) {

    //     if (i<0 || j<0) {
    //         return 0;
    //     }


    //     if (str1[i] == str2[j]) {
    //         return 1 + f(str1, str2, i-1, j-1);
    //     }
    //     else
    //         return Math.max(f(str1, str2, i, j-1), f(str1, str2, i-1, j));
    // }
}

