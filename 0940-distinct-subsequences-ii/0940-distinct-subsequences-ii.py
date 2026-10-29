class Solution:
    MOD = 1_000_000_007

    def __init__(self):
        self.dp = [None] * 2001
        self.prev = []

    def solve(self, i):

        if i == 0:
            return 1

        if self.dp[i] is not None:
            return self.dp[i]

        total = (2 * self.solve(i - 1)) % self.MOD

        if self.prev[i] != 0:
            duplicate = self.solve(self.prev[i] - 1)
            total = (total - duplicate + self.MOD) % self.MOD

        self.dp[i] = total
        return total

    def distinctSubseqII(self, s: str) -> int:

        n = len(s)
        lastSeen = [0] * 26

        self.prev.append(0)

        for i in range(1, n + 1):
            idx = ord(s[i - 1]) - ord('a')
            self.prev.append(lastSeen[idx])
            lastSeen[idx] = i

        return (self.solve(n) - 1 + self.MOD) % self.MOD