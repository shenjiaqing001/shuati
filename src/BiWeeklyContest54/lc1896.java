package BiWeeklyContest54;

import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/12
 */
public class lc1896 {

    class BitTreeNode {
        char c;
        BitTreeNode left = null;
        BitTreeNode right = null;
        int value = 0;

        BitTreeNode() {

        }

        BitTreeNode(char c) {
            this.c = c;
        }
    }

    public int minOperationsToFlip(String expression) {
        BitTreeNode root = buildTree("(" + expression + ")");
        System.out.println(root);
        int res = dfs(root);


        return cal(root, 1 - res);
    }

    public int cal(BitTreeNode root, int to) {
        if (root.value == to) return 0;
        if (to == 1) {
            if (root.c == '0') return 1;
            if (root.c == '|') {
                return Math.min(cal(root.left, to), cal(root.right, to));
            } else if (root.c == '&') {
                return Math.min(cal(root.left, to), cal(root.right, to)) + 1;
            }
        } else if (to == 0) {
            if (root.c == '1') return 1;
            if (root.c == '|') {
                return Math.min(cal(root.left, to), cal(root.right, to)) + 1;
            } else if (root.c == '&') {
                return Math.min(cal(root.left, to), cal(root.right, to));
            }
        }
        return 0;
    }

    public int dfs(BitTreeNode root) {
        if (root.c == '1') return 1;
        if (root.c == '0') return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.c == '|') {
            root.value = left | right;
        } else {
            root.value = left & right;
        }
        return root.value;
    }


    public BitTreeNode buildTree(String expression) {
        Stack<BitTreeNode> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c != ')') {
                BitTreeNode tmp = new BitTreeNode(c);
                if (c == '0' || c == '1') {
                    tmp.value = c - '0';
                }
                stack.add(tmp);
            } else {
                Stack<BitTreeNode> s = new Stack<>();
                while (stack.peek().c != '(') {
                    s.add(stack.pop());
                }
                stack.pop();
                BitTreeNode tmp = s.pop();
                while (!s.isEmpty()) {
                    BitTreeNode op = s.pop();
                    BitTreeNode num = s.pop();
                    op.left = tmp;
                    op.right = num;
                    tmp = op;
                }
                stack.add(tmp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        lc1896 test = new lc1896();
        test.minOperationsToFlip("(0&0)&(0&1&0)");
    }


}
