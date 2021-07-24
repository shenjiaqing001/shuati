/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/23
 */
public class lc814 {
    public TreeNode pruneTree(TreeNode root) {
        if (!hasOne(root)) {
            return null;
        }
        return root;
    }

    public boolean hasOne(TreeNode root) {
        if (root == null) return false;
        boolean left = hasOne(root.left);
        boolean right = hasOne(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;

        if (left || right || root.val == 1) return true;
        else return false;
    }
}
