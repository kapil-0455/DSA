class Solution {

    static final int MOD = 1_000_000_007;

    Integer[] dp = new Integer[2001];
    ArrayList<Integer> prev = new ArrayList<>();

    public int solve(int i) {

        if (i == 0) {
            return 1;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        long total = (2L * solve(i - 1)) % MOD;

        if (prev.get(i) != 0) {
            int duplicate = solve(prev.get(i) - 1);
            total = (total - duplicate + MOD) % MOD;
        }

        return dp[i] = (int) total;
    }

    public int distinctSubseqII(String s) {

        int n = s.length();
        int[] lastSeen = new int[26];

        prev.add(0);
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev.add(lastSeen[idx]);
            lastSeen[idx] = i;
        }

        return (solve(n) - 1 + MOD) % MOD;
    }
}