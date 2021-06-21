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



        return 0;
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
