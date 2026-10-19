class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        nums.sort()

        l = 0
        r = len(nums) - 1
        first = -1
        last = -1

        # First occurrence
        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                first = mid
                r = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1

        # Target nahi mila
        if first == -1:
            return []

        l = first
        r = len(nums) - 1

        # Last occurrence
        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                last = mid
                l = mid + 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1

        # First se last tak saare indices
        ans = []
        for i in range(first, last + 1):
            ans.append(i)

        return ans