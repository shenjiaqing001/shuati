import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1028 {
    int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        char[] c = traversal.toCharArray();
        TreeNode root = new TreeNode(getNum(c));
        stack.add(root);
        while (index < traversal.length()) {
            int depth = getDepth(c);
            int num = getNum(c);
            while (stack.size() > depth) stack.pop();
            TreeNode fa = stack.peek();
            TreeNode child = new TreeNode(num);
            if (fa.left == null) fa.left = child;
            else fa.right = child;
            stack.add(child);
        }
        while (stack.size() > 1) stack.pop();
        return stack.pop();
    }

    public int getNum(char[] c) {
        int res = 0;
        while (index < c.length && c[index] != '-') {
            res = res * 10 + c[index] - '0';
            index++;
        }
        return res;
    }

    public int getDepth(char[] c) {
        int res = 0;
        while (index < c.length && c[index] == '-') {
            res += 1;
            index++;
        }
        return res;
    }


}
