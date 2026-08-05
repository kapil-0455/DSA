class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            maxi = Math.max(maxi , nums[i]);
            mini = Math.min(mini , nums[i]);
        }

        for(int i = mini ;i<=maxi ;i++ ){
            if(!set.contains(i)){
                ans.add(i);
            }
        }

        return ans;

        
            
    }
}