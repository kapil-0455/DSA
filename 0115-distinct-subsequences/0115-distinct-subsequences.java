class Solution {

    Integer[][] dp;

    public int solve(String s, String t, int i, int j) {

        // t complete ho gayi
        if (j < 0) return 1;

        // s khatam ho gayi, t abhi baaki
        if (i < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] =
                solve(s, t, i - 1, j - 1)   // match use
              + solve(s, t, i - 1, j);      // s ka char skip
        } else {
            dp[i][j] = solve(s, t, i - 1, j); // sirf skip
        }

        return dp[i][j];
    }

    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        dp = new Integer[m][n];

        return solve(s, t, m - 1, n - 1);
    }
}
