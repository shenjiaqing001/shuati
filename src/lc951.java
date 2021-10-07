/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/16/20
 */
public class lc951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return root1 == root2;

        return root1.val == root2.val && flipEquiv(root1.left, root2.right) &&
                flipEquiv(root1.right, root2.left) ||
                flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }


    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return root1 == root2;

        return root1.val == root2.val &&
                ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                        (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)));
    }
}
