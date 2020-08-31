/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
                                         TreeNode q) {
        int lo = p.val;
        int hi = q.val;
        if (hi < lo) {
            int tmp = lo;
            lo = hi;
            hi = tmp;
        }
        return lca(root, lo, hi);
    }

    public TreeNode lca(TreeNode root, int lo, int hi) {
        if (root.val == lo || root.val == hi) return root;
        if (lo < root.val && root.val < hi) return root;

        if (hi < root.val) return lca(root.left, lo, hi);
        if (lo > root.val) return lca(root.right, lo, hi);
        return null;
    }
}
