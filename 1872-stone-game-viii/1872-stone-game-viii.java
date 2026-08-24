class Solution {
    int n ;
    Integer dp[];
    public int solve(int i  , int prefix[]){
        if( i == n-1) return prefix[n-1];

        if (dp[i] != null) return dp[i];
        
        int take = prefix[i] - solve(i+1 , prefix);
        int notTake = solve(i+1 , prefix);

        return dp[i] = Math.max(take , notTake);
    }
    public int stoneGameVIII(int[] stones) {
        n = stones.length;

        dp = new Integer[n+1];
        int prefixSum[] = new int[n];

        prefixSum[0] = stones[0];
        for ( int i =1 ;i < n ;i++){
            prefixSum[i] = prefixSum[i-1] + stones[i]; 
        }

        return solve(1 , prefixSum);
    }
}