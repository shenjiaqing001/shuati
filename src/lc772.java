import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc772 {

    int now = 0;

    public int calculate(String s) {
        return calDfs((s + "+").toCharArray());
    }


    public int calDfs(char[] c) {
        Stack<Integer> stack = new Stack<>();
        char tmp = '+';

        int num = 0;

        while (now < c.length) {
            if (c[now] == ' ') {

            } else if (c[now] >= '0' && c[now] <= '9') {
                num = num * 10 + c[now] - '0';
            } else if (c[now] == '(') {
                now++;
                num = calDfs(c);
            } else {
                if (tmp == '+') stack.add(num);
                if (tmp == '-') stack.add(-num);
                if (tmp == '*') {
                    int last = stack.pop();
                    stack.add(last * num);
                }
                if (tmp == '/') {
                    int last = stack.pop();
                    stack.add(last / num);
                }
                num = 0;
                tmp = c[now];
                if (c[now] == ')') break;
            }
            now++;
        }

        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
