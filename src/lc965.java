/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        boolean flag = true;
        if (root.left != null) {
            if (root != root.left) return false;
            if (!isUnivalTree(root.left)) flag = false;
        }
        if (root.right != null) {
            if (root != root.right) return false;
            if (!isUnivalTree(root.right)) flag = false;
        }
        return flag;
    }
}
