class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        char nums[] = s.toCharArray();
        HashMap<Character , Integer>mp = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for (int r = 0 ; r < n ; r++){
            mp.put(nums[r] , mp.getOrDefault(nums[r] , 0) + 1);

            while( mp.get(nums[r]) > 2) {
                mp.put(nums[l] , mp.get(nums[l]) - 1);
                if(mp.get(nums[l]) == 0) mp.remove(nums[l]);

                l++;
            }

            maxLen = Math.max(maxLen , r - l +1 );

        }

        return maxLen;
    }
}