class Solution {

    public int solve(String str) {
        int n = str.length();
        int cnt = 0;

        for (int i = n - 1; i >= 3; i -= 3) {
            cnt++;
        }

        return cnt;
    }

    public int countCommas(int n) {
        if (n < 1000) return 0;

        int commas = 0;

        for (int i = 1000; i <= n; i++) {
            commas += solve(String.valueOf(i));
        }

        return commas;
    }
}