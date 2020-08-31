import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */
public class lc145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode now = stack.peek();
            if (now.right == null) {
                list.add(now.val);
                stack.pop();
            } else {
                root = now.right;
                now.right = null;
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
            }
        }
        return list;
    }
}
