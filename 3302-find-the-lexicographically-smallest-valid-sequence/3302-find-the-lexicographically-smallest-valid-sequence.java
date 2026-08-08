class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int rightHandSuffix[] = new int[n + 1];  
        int i = n - 1;
        int j = m - 1;

        int rightMatched = 0;
        while (i >= 0) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                rightMatched++;
                j--;
            }

            rightHandSuffix[i] = rightMatched;
            i--;
        }

        List<Integer> lis = new ArrayList<>();
        i = 0;
        j = 0;

        boolean canChange = true;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                lis.add(i);
                j++;
            }
            else if (canChange == true && rightHandSuffix[i + 1] >= m - j - 1) {
                lis.add(i);
                j++;
                canChange = false;
            }

            i++;
        }

        if (lis.size() != m) return new int[]{};
        int ans[] = new int[m];

        for (int k = 0; k < m; k++) {
            ans[k] = lis.get(k);
        }

        return ans;
    }
}