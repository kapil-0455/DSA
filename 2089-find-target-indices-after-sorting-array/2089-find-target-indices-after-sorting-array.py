class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        nums.sort()

        l = 0
        r = len(nums) - 1
        ans = []

        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                ans.append(mid)

                # Left aur right dono sides search karo
                left = mid - 1
                while left >= 0 and nums[left] == target:
                    ans.append(left)
                    left -= 1

                right = mid + 1
                while right < len(nums) and nums[right] == target:
                    ans.append(right)
                    right += 1

                break

            elif nums[mid] < target:
                l = mid + 1

            else:
                r = mid - 1

        ans.sort()
        return ans