import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/29
 */
public class lc224 {
    int pos = 0;

    public int calculate(String s) {
        s = s + "+";
        return cal(s.toCharArray());
    }

    public int cal(char[] c) {
        int res = 0;
        int num = 0;
        int op = '+';

        while (pos < c.length) {
            if (c[pos] == ' ') {
                pos++;
                continue;
            }
            if (c[pos] == ')') {
                if (op == '+') res += num;
                else res -= num;
                pos++;
                return res;
            } else if (c[pos] == '(') {
                pos++;
                int inside = cal(c);
                if (op == '+') res += inside;
                else res -= inside;
            } else if (c[pos] <= '9' && c[pos] >= '0') {
                num = num * 10 + (c[pos++] - '0');
            } else {
                if (op == '+') res += num;
                else res -= num;
                num = 0;
                op = c[pos++];
            }
        }
        return res;
    }
}
