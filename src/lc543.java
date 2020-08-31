/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int includeThis = depth(root.left) + depth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(includeThis, Math.max(left, right));
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }
}
