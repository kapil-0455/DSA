class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int ans = k;

        while (set.contains(ans)) {
            ans += k;
        }

        return ans;
    }
}