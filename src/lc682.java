import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < ops.length; ++i) {
            if (ops[i].equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.add(first);
                stack.add(first + second);
                res += stack.peek();
            } else if (ops[i].equals("D")) {
                int last = stack.peek();
                res += last * 2;
                stack.add(last * 2);
            } else if (ops[i].equals("C")) {
                int last = stack.pop();
                res -= last;
            } else {
                int now = Integer.valueOf(ops[i]);
                stack.add(now);
                res += now;
            }
        }
        return res;
    }
}
