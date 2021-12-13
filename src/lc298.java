/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/4/21
 */
public class lc298 {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, Math.max(left, right));
        if (root.left != null && root.left.val == root.val + 1) left += 1;
        else left = 1;
        if (root.right != null && root.right.val == root.val + 1) right += 1;
        else right = 1;
        max = Math.max(max, Math.max(left, right));
        return Math.max(left, right);
    }
}
