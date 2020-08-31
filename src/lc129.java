/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/5/20
 */
public class lc129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null)
            sum += num * 10 + root.val;
        else {
            if (root.left != null)
                dfs(root.left, num * 10 + root.val);
            if (root.right != null)
                dfs(root.right, num * 10 + root.val);
        }
    }
}
