import com.sun.source.tree.Tree;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
                                         TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root :
                left == null ? right : left;
    }
}
