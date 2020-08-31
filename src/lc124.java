/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/4/20
 */
public class lc124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxpath(root);
        return max;
    }

    public int maxpath(TreeNode root) {
        if (root == null) return 0;

        int left = maxpath(root.left);
        int right = maxpath(root.right);

        if (left < 0) left = 0;
        if (right < 0) right = 0;

        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }


}
