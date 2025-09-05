package DSA.DP;

public class WildcardMatching {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "mississippi";
        String p = "m??*ss*?i*pi";

        System.out.println(solution.isMatch(s, p));

    }

    static class Solution {
        public boolean isMatch(String s, String p) {

            int n = s.length();
            int m = p.length();

            //return f(s,p, n-1, m-1);

            Boolean[][] dpMemo = new Boolean[n+1][m+1];
            //return f(s,p, n, m, dpMemo);

            boolean[][] dp = new boolean[n+1][m+1];
            //return f(s,p, n, m, dp);

            return fOpt(s,p, n, m);

        }

        public boolean f(String s, String p, int i, int j) {
            if (i < 0) {
                for (int ii = 0; ii <= j; ii++) {
                    if (p.charAt(ii) != '*') {
                        return false;
                    }
                }
                return true;
            }
            if (j < 0 && i >= 0) {
                return false;
            }

            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                return f(s, p, i-1,j-1);

            else if (p.charAt(j) == '*') {
                return (f(s, p, i-1, j) || f(s, p, i,j-1));
            }
            else return false;
        }

        public boolean f(String s, String p, int i, int j, Boolean[][] dp) {
            if (i==0 && j==0 )
                return true;
            if (i == 0) {
                for (int ii = 1; ii <= j; ii++) {
                    if (p.charAt(ii-1) != '*') {
                        return dp[i][ii] =false;
                    }
                }
                return dp[i][j] = true;
            }

            if (j == 0 && i > 0) {
                return false;
            }

            if (dp[i][j] != null) return dp[i][j];


            if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                return dp[i][j] = f(s, p, i-1,j-1, dp);

            else if (p.charAt(j-1) == '*') {
                return dp[i][j] = (f(s, p, i-1, j, dp) || f(s, p, i,j-1, dp));
            }
            else return dp[i][j] = false;

        }

        public boolean f(String s, String p, int n, int m, boolean[][] dp) {

            dp[0][0] = true;

            for (int ii = 1; ii <= m; ii++) {
                if (p.charAt(ii-1) != '*') {
                    dp[0][ii] =false;
                }
                // only if all previous were '*'
                else dp[0][ii] = dp[0][ii-1]; // IMPORTANT - Next entry will only be true if previous is true.
            }


            for (int i=1; i<=n; i++) {
                for (int j=1; j<=m;j++) {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                        dp[i][j] = dp[i-1][j-1];

                    else if (p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                    else dp[i][j] = false;
                }
            }

            return dp[n][m];
        }

        public boolean fOpt(String s, String p, int n, int m) {

            boolean[] prev= new boolean[m+1];
            prev[0] = true;

            for (int ii = 1; ii <= m; ii++) {
                if (p.charAt(ii-1) != '*') {
                    prev[ii] =false;
                }
                // only if all previous were '*'
                else prev[ii] = prev[ii-1]; // IMPORTANT - Next entry will only be true if previous is true.
            }


            for (int i=1; i<=n; i++) {
                boolean[] curr= new boolean[m+1];
                for (int j=1; j<=m;j++) {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                        curr[j] = prev[j-1];

                    else if (p.charAt(j-1) == '*') {
                        curr[j] = prev[j] || curr[j-1];
                    }
                    else curr[j] = false;
                }
                prev = curr;
            }

            return prev[m];
        }
    }
}
