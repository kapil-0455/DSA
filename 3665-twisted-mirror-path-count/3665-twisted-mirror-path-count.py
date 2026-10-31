class Solution:
    def __init__(self):
        self.LEFT = 0
        self.UP = 1
        self.MOD = 10**9 + 7
        self.m = 0
        self.n = 0

    def solve(self, grid, i, j, cameFrom, t):

        # Out of bounds
        if i >= self.m or j >= self.n:
            return 0

        # Destination reached
        if i == self.m - 1 and j == self.n - 1:
            return 1

        # Memoization check
        if t[i][j][cameFrom] != -1:
            return t[i][j][cameFrom]

        # Mirror
        if grid[i][j] == 1:

            if cameFrom == self.LEFT:
                t[i][j][cameFrom] = self.solve(
                    grid, i + 1, j, self.UP, t
                )
            else:
                t[i][j][cameFrom] = self.solve(
                    grid, i, j + 1, self.LEFT, t
                )

            return t[i][j][cameFrom]

        # grid[i][j] == 0
        totalPathsCount = 0

        totalPathsCount = (
            totalPathsCount +
            self.solve(grid, i, j + 1, self.LEFT, t)
        ) % self.MOD

        totalPathsCount = (
            totalPathsCount +
            self.solve(grid, i + 1, j, self.UP, t)
        ) % self.MOD

        t[i][j][cameFrom] = totalPathsCount

        return t[i][j][cameFrom]

    def uniquePaths(self, grid):

        self.m = len(grid)
        self.n = len(grid[0])

        # 3D DP array initialized with -1
        t = [[[-1 for _ in range(2)] for _ in range(self.n)]
             for _ in range(self.m)]

        return self.solve(grid, 0, 0, self.LEFT, t)