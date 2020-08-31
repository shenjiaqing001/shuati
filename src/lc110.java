import com.sun.source.tree.Tree;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int depth  = depth(root);
        if (depth == -1) return false;
        else return true;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        if (leftDepth == -1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
