class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIdx = -1;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        int fromFront = right + 1;
        int fromBack = n - left;
        int frontBack = (left + 1) + (n - right);

        return Math.min(fromFront, Math.min(fromBack, frontBack));
    }
}