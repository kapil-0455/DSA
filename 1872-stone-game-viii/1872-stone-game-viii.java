class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int[] prefixSum = new int[n];

        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        int[] dp = new int[n];

        // Base case
        dp[n - 1] = prefixSum[n - 1];

        // Bottom-up
        for (int i = n - 2; i >= 1; i--) {
            int take = prefixSum[i] - dp[i + 1];
            int notTake = dp[i + 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[1];
    }
}