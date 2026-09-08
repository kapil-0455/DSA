class Solution {

    public int countCommas(int n) {
        int commas = 0;

        for (int i = 1000; i <= n; i++) {
            commas += (String.valueOf(i).length() - 1) / 3;
        }

        return commas;
    }
}