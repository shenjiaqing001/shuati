/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/24/21
 */
public class lc1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) return null;
        for (TreeNode node : nodes) {
            if (node.val == root.val) return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        return left != null && right != null ? root : left == null ? right : left;
    }
}
