class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        dp = [[set() for j in range(n)] for i in range(m)]

        dp[0][0].add(grid[0][0])

        for i in range(m):
            for j in range(n):

                if i == 0 and j == 0:
                    continue

                combined = set()

                if i > 0:
                    combined.update(dp[i - 1][j])

                if j > 0:
                    combined.update(dp[i][j - 1])

                for xor_val in combined:
                    result = xor_val ^ grid[i][j]
                    dp[i][j].add(result)

        return min(dp[m - 1][n - 1])