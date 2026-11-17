from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        n = len(nums)
        dq = deque()

        ans = []

        for i in range(n):

            # Remove elements outside the current window
            if dq and dq[0] <= i - k:
                dq.popleft()

            # Maintain decreasing order
            while dq and nums[dq[-1]] <= nums[i]:
                dq.pop()

            dq.append(i)

            # Store maximum of current window
            if i >= k - 1:
                ans.append(nums[dq[0]])

        return ans