
class Solution {
    int res ;

    public int[] solve(TreeNode root){
        if (root == null) return new int[]{0,0};

        int[] left = solve(root.left);
        int right[] = solve(root.right);

        int totalSum = left[0] + right[0] + root.val;
        int totalLen = left[1] + right[1] + 1;

        int average = totalSum / totalLen;

        if(average == root.val){
            res++;

        }

        return new int[]{totalSum , totalLen};
    }
    public int averageOfSubtree(TreeNode root) {
        res = 0;

        solve(root);

        return res;
    }
}