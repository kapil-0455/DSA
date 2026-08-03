class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int prev = 0;
        int prev1 = 0;
        int prev2 = 0;

        for ( int i = stoneValue.length - 1 ; i >= 0 ; i--){
            int res = Integer.MIN_VALUE;

            res = Math.max(res , stoneValue[i] - prev);
            if(i+2 <= n){
                res = Math.max(res , stoneValue[i] + stoneValue[i+1] - prev1);
            }
            if (i+3 <= n) res = Math.max(res , stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - prev2);

            prev2 = prev1;
            prev1 = prev;
            prev = res;
        }

        int diff = prev;

        if(prev > 0) return "Alice";
        else if (prev < 0) return "Bob";
        else return "Tie";
    }
}