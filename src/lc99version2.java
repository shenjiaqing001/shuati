import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/1
 */
public class lc99version2 {
    TreeNode one = null;
    TreeNode two = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (root.val < pre.val) {
            if (one == null) one = pre;
            if (one != null) two = root;
        }
        pre = root;
        dfs(root.right);
    }
}
