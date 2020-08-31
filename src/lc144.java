import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */
public class lc144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.right;
        }

        while (!stack.isEmpty()) {
            TreeNode now = stack.peek();
            if (now.left == null) {
                list.add(now.val);
                stack.pop();
            } else {
                root = now.left;
                now.left = null;
                while (root != null) {
                    stack.add(root);
                    root = root.right;
                }
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; --i)
            res.add(list.get(i));
        return res;
    }
}
