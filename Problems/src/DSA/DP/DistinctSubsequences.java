package DSA.DP;

class DistinctSubsequences {

    public static void main(String[] args) {

        String s = "babgbag", t = "bag";
        Solution sol = new Solution();
        System.out.println(sol.numDistinct(s, t));

    }

    public static class Solution {
        public int numDistinct(String s, String t) {

            int m = s.length();
            int n = t.length();


            //Recursion
            //return f(s,t,m-1,n-1);

            //Memo
            Integer[][] dp = new Integer[m][n];
            //return f(s,t,m-1,n-1, dp);

            //DP
            //Here Always use 1 based indexing for DP
            int[][] dp2 = new int[m + 1][n + 1];
            //return fDP(s,t,m,n, dp2);

            //return fDP(s,t,m,n);

            return fDPOpti(s, t, m, n);

        }

        public int f(String s, String t, int i, int j) {

            if (j < 0)
                return 1;

            if (i < 0)
                return 0;


            if (s.charAt(i) == t.charAt(j)) {
                return f(s, t, i - 1, j - 1) + f(s, t, i - 1, j);
            } else
                return f(s, t, i - 1, j);

        }

        public int f(String s, String t, int i, int j, Integer dp[][]) {

            if (j < 0)
                return 1;

            if (i < 0)
                return 0;

            if (dp[i][j] != null)
                return dp[i][j];


            if (s.charAt(i) == t.charAt(j)) {
                return dp[i][j] = f(s, t, i - 1, j - 1) + f(s, t, i - 1, j);
            } else
                return dp[i][j] = f(s, t, i - 1, j);

        }

        public int fDP(String s, String t, int m, int n, int[][] dp) {

            for (int i = 0; i < m; i++)
                dp[i][0] = 1;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {

                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else
                        dp[i][j] = dp[i - 1][j];

                }
            }

            return dp[m][n];
        }

        public int fDP(String s, String t, int m, int n) {

            int[] prev = new int[n + 1];

            prev[0] = 1;

            for (int i = 1; i <= m; i++) {
                int[] curr = new int[n + 1];
                curr[0] = 1;
                for (int j = n; j >= 1; j--) {

                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        curr[j] = prev[j - 1] + prev[j];
                    } else
                        curr[j] = prev[j];

                }
                prev = curr;
            }

            return prev[n];
        }

        public int fDPOpti(String s, String t, int m, int n) {

            int[] prev = new int[n + 1];

            prev[0] = 1;

            for (int i = 1; i <= m; i++) {
                for (int j = n; j >= 1; j--) {

                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        prev[j] = prev[j - 1] + prev[j];
                    }

                }
            }

            return prev[n];
        }
    }
}
