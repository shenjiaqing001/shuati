import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc99 {

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode one = null;
        TreeNode two = null;

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;

            TreeNode now = stack.pop();

            if (now.val < pre.val) {
                if (one == null)
                    one = pre;
                if (one != null)
                    two = now;
            }
            pre = now;
            root = now.right;
        }

        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }
}
