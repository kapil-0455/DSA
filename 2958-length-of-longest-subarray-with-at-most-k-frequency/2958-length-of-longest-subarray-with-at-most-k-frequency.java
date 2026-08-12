class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxLen = 0;

        while( r < n){

            mp.put(nums[r] , mp.getOrDefault(nums[r] , 0) + 1);

            while(mp.get(nums[r]) > k){
                mp.put(nums[l] , mp.get(nums[l]) - 1);
                if (mp.get(nums[l]) == 0 ) mp.remove(nums[l]);
                l++;
            }

            maxLen = Math.max(maxLen  , r - l +1 ) ; 
            r++;
        }

        return maxLen;


    }
}