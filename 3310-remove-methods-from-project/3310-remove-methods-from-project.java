class Solution {

    public void dfs(int start, List<List<Integer>> adj, boolean safe[]) {
        safe[start] = true;

        for (int adjEle : adj.get(start)) {
            if (safe[adjEle]) continue;
            dfs(adjEle, adj, safe);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : invocations) {
            adj.get(e[0]).add(e[1]);
        }

        boolean safe[] = new boolean[n];

        dfs(k, adj, safe);

        for (int[] e : invocations) {
            int u = e[0];
            int v = e[1];

            if (!safe[u] && safe[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!safe[i])
                ans.add(i);
        }

        return ans;
    }
}