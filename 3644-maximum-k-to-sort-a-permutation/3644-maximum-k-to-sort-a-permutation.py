class Solution:
    def sortPermutation(self, nums: list[int]) -> int:
        n = len(nums)
        K = -1  # All bits set

        for i in range(n):
            if nums[i] != i:
                K &= nums[i]

        return 0 if K == -1 else K