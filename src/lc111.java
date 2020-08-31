import com.sun.source.tree.Tree;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/28/20
 */
public class lc111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return depth(root);
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if (left == 0) return right + 1;
        if (right == 0) return left + 1;
        return Math.min(left, right) + 1;
    }

}
