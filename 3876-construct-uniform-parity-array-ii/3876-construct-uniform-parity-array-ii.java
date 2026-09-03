class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int mini = Integer.MAX_VALUE;
        for (int ele : nums1){
            mini = Math.min(ele , mini);
        }

        if (mini % 2 == 1){
            return true;
        }

        for( int ele : nums1){
            if (ele % 2 == 1) return false;
        }

        return true;
    }
}