/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/4
 */
public class lc563 {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return Math.abs(left - right) + findTilt(root.left) + findTilt(root.right);
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
