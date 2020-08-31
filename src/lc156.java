import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/20
 */
public class lc156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        while (root.left != null) {
            stack.add(root);
            root = root.left;
        }
        TreeNode newHead = root;
        TreeNode last = newHead;

        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            last.right = tmp;
            if (tmp.right != null) {
                last.left = upsideDownBinaryTree(tmp.right);
            } else {
                last.left = null;
            }
            tmp.left = null;
            tmp.right = null;
            last = last.right;
        }

        return newHead;
    }
}
