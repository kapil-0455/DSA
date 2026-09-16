class Solution:
    MOD = 1000000007

    def numberOfSets(self, n, K):

        dp = [[0] * (n + 1) for _ in range(K + 1)]

        for i in range(n + 1):
            dp[0][i] = 1 if i < n else 0

        for k in range(1, K + 1):
            prevRowSum = [0] * (n + 1)
            
            for x in range(n - 1, -1, -1):
                prevRowSum[x] = (
                    prevRowSum[x + 1] + dp[k - 1][x]
                ) % self.MOD

            for i in range(n - 1, -1, -1):

                skip = dp[k][i + 1]

                take = prevRowSum[i + 1]

                dp[k][i] = (take + skip) % self.MOD

        return dp[K][0]