from collections import deque

class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def bfs(self, i, j, grid):
        total = grid[i][j]
        grid[i][j] = 0

        que = deque()
        que.append((i, j))

        while que:
            cur_i, cur_j = que.popleft()

            for di, dj in self.directions:
                i_ = cur_i + di
                j_ = cur_j + dj

                if (0 <= i_ < self.m and
                    0 <= j_ < self.n and
                    grid[i_][j_] > 0):

                    total += grid[i_][j_]
                    grid[i_][j_] = 0
                    que.append((i_, j_))

        return total

    def countIslands(self, grid, k):
        self.m = len(grid)
        self.n = len(grid[0])

        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] > 0:
                    total = self.bfs(i, j, grid)

                    if total % k == 0:
                        count += 1

        return count