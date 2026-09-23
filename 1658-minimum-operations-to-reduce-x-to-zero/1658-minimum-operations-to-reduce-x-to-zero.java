class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;

        for (int num : nums) total += num;

        int target = total - x;
        if (target < 0) return -1;

        int l = 0, sum = 0, maxLen = -1;

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum > target) {
                sum -= nums[l];
                l++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}