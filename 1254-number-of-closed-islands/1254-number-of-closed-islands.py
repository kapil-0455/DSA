class Solution:
    def dfs(self, grid, r, c):
        if r < 0 or r >= self.m or c < 0 or c >= self.n:
            return False

        if grid[r][c] == 1:
            return True

        grid[r][c] = 1

        left = self.dfs(grid, r, c - 1)
        right = self.dfs(grid, r, c + 1)
        up = self.dfs(grid, r - 1, c)
        down = self.dfs(grid, r + 1, c)

        return left and right and up and down

    def closedIsland(self, grid):
        self.m = len(grid)
        self.n = len(grid[0])

        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 0:
                    count += self.dfs(grid, i, j)

        return count