import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc227 {
    public int calculate(String s) {
        s = s + "+";
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c <= '9' && c >= '0') {
                num = num * 10 + c - '0';
                continue;
            }

            if (op == '+') {
                stack.add(num);
            }
            if (op == '-') {
                stack.add(-num);
            }
            if (op == '/') {
                int last = stack.pop();
                stack.add(last / num);
            }
            if (op == '*') {
                int last = stack.pop();
                stack.add(last * num);
            }
            num = 0;
            op = c;
        }
        int res = 0;
        while (!stack.empty()) res += stack.pop();
        return res;
    }
}
