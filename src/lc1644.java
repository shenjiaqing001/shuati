import com.sun.source.tree.Tree;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/21/21
 */
public class lc1644 {
    public boolean exist(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return exist(root.left, node) || exist(root.right, node);
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root :
                left == null ? right : left;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!exist(root, p) || !exist(root, q)) return null;
        return LCA(root, p, q);
    }
}
