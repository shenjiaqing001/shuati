/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/13
 */
public class lc865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int[] depth = new int[501];
        dfs(depth, root);
        while (true) {
            if (root.left == null && root.right == null) break;
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                int left = depth[root.left.val];
                int right = depth[root.right.val];
                if (left == right) break;
                if (left > right) root = root.left;
                else root = root.right;
            }
        }
        return root;
    }

    public int dfs(int[] depth, TreeNode root) {
        if (root == null) return 0;
        depth[root.val] = Math.max(dfs(depth, root.left), dfs(depth, root.right)) + 1;
        return depth[root.val];
    }
}
