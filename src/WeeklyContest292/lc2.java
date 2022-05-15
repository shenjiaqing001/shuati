package WeeklyContest292;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/7/22
 */
public class lc2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        if (sum / count == root.val) res += 1;
        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
}
