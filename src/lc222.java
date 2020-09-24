/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/23
 */
public class lc222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }
}
