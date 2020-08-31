/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) convertBST(root.right);
        sum += root.val;
        root.val = sum;
        if (root.left != null) convertBST(root.left);
        return root;
    }
}
