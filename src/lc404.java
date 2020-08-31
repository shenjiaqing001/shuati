import com.sun.source.tree.Tree;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/24/20
 */
public class lc404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumLeft(root.left, true) + sumLeft(root.right, false);
    }

    public int sumLeft(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft == true)
            return root.val;
        return sumLeft(root.left, true) + sumLeft(root.right, false);
    }
}
