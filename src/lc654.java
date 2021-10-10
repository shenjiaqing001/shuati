import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/4
 */
public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!stack.isEmpty() && stack.peekLast().val < num) {
                node.left = stack.pollLast();
            }
            if (!stack.isEmpty()) {
                stack.peekLast().right = node;
            }
            stack.add(node);
        }
        return stack.peekFirst();
    }
}
