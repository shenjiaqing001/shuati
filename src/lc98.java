/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/26/20
 */
public class lc98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode node, Long low, Long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return isValidNode(node.left, low, (long) node.val) &&
                isValidNode(node.right, (long) node.val, high);
    }
}
