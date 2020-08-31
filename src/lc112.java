/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/28/20
 */
public class lc112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == sum)
            return true;

        if (root.left != null) {
            if (hasPathSum(root.left, sum - root.val))
                return true;
        }

        if (root.right != null) {
            if (hasPathSum(root.right, sum - root.val))
                return true;
        }

        return false;
    }
}
