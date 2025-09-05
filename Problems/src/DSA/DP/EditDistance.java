package DSA.DP;

public class EditDistance {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String word1 = "horse";
        String  word2 = "ros";
        System.out.println(sol.minDistance(word1, word2));
    }


    static class Solution {
        public int minDistance(String word1, String word2) {

            int m = word1.length();
            int n = word2.length();

            //Recursion
            //return f(word1, word2, m-1, n-1);

            //Memo
            Integer[][] dpMemo = new Integer[m][n];
            //return f(word1, word2, m-1, n-1, dpMemo);

            //DP
            //Move to 1 based indexing
            //return fDP(word1, word2, m, n);

            //DP Optimization
            //Move to 1 based indexing
            return fDPOpti(word1, word2, m, n);

        }

        public int f(String s, String t, int i, int j) {

            if (j < 0) return i+1;
            if (i < 0) return j+1;

            if (s.charAt(i) == t.charAt(j)) {
                return 0 + f(s, t, i-1, j-1);
            }
            else {
                int delete = 1 + f(s, t, i-1, j);
                int insert = 1 + f(s,t, i, j-1);
                int replace = 1 + f(s, t, i-1, j-1);
                return Math.min(Math.min(delete, insert), replace);
            }
        }

        public int f(String s, String t, int i, int j, Integer[][] dp) {

            if (j < 0) return i+1;
            if (i < 0) return j+1;

            if (dp[i][j] != null) return dp[i][j];

            if (s.charAt(i) == t.charAt(j)) {
                return dp[i][j] = 0 + f(s, t, i-1, j-1);
            }
            else {
                int delete = 1 + f(s, t, i-1, j);
                int insert = 1 + f(s,t, i, j-1);
                int replace = 1 + f(s, t, i-1, j-1);
                return dp[i][j] =  Math.min(Math.min(delete, insert), replace);
            }
        }

        public int fDP(String s, String t, int m, int n) {

            int[][] dp = new int[m+1][n+1];

            for (int i = 0; i<=m; i++)
                dp[i][0] = i;

            for (int j = 1; j<=n; j++)
                dp[0][j] = j;

            for (int i=1; i<=m; i++) {
                for (int j=1; j<=n; j++) {

                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        dp[i][j] = 0 + dp[i-1][j-1];
                    }
                    else {
                        int delete = 1 + dp[i-1][j];
                        int insert = 1 + dp[i][j-1];
                        int replace = 1 + dp[i-1][j-1];
                        dp[i][j] =  Math.min(Math.min(delete, insert), replace);
                    }
                }
            }
            return dp[m][n];
        }

        public int fDPOpti(String s, String t, int m, int n) {

            int[] prev = new int[n+1];

            prev[0] = 0;
            for (int j = 1; j<=n; j++)
                prev[j] = j;

            for (int i=1; i<=m; i++) {
                int[] curr = new int[n+1];
                curr[0] = i;
                for (int j=1; j<=n; j++) {

                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        curr[j] = 0 + prev[j-1];
                    }
                    else {
                        int delete = 1 + prev[j];
                        int insert = 1 + curr[j-1];
                        int replace = 1 + prev[j-1];
                        curr[j] =  Math.min(Math.min(delete, insert), replace);
                    }
                }
                prev = curr;
            }
            return prev[n];
        }
    }
}
