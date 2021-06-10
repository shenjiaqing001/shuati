/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/11
 */
public class lc1302 {
    public int deepestLeavesSum(TreeNode root) {
        int depth = findDeepest(root);
        return sum(root, depth);
    }

    public int findDeepest(TreeNode root) {
        if (root == null) return 0;
        int left = findDeepest(root.left);
        int right = findDeepest(root.right);
        return Math.max(left, right) + 1;
    }

    public int sum(TreeNode root, int depth) {
        if (root == null) return 0;
        if (depth == 1) return root.val;
        return sum(root.left, depth - 1) + sum(root.right, depth - 1);
    }
}
