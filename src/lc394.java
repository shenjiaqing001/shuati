import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc394 {
    int nowIndex = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();

        return decode(c);
    }

    public String decode(char[] c) {
        StringBuilder sb = new StringBuilder();
        while (nowIndex < c.length) {
            if (Character.isDigit(c[nowIndex])) {
                int times = getNum(c);
                String s = decode(c);
                for (int j = 0; j < times; ++j) sb.append(s);
            } else if (c[nowIndex] == ']') {
                return sb.toString();
            } else {
                sb.append(c[nowIndex]);
            }
            nowIndex++;
        }
        return sb.toString();
    }

    public int getNum(char[] c) {
        int num = 0;
        while (nowIndex < c.length) {
            if (c[nowIndex] == '[') {
                nowIndex++;
                return num;
            }
            num = num * 10 + (c[nowIndex] - '0');
            nowIndex++;
        }
        return num;
    }

    public String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();
        s = "1[" + s + "]";
        Stack<String> stack = new Stack<>();
        int tmp = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (tmp == 0) tmp = 1;
                stack.add(String.valueOf(tmp));
                stack.add("[");
                tmp = 0;
            } else if (c >= '0' && c <= '9') {
                if (sb.length() > 0) {
                    stack.add(sb.toString());
                    sb = new StringBuilder();
                }
                tmp = 10 * tmp + c - '0';
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == ']') {
                StringBuilder str = new StringBuilder();
                while (stack.peek() != "[") {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                String times = stack.pop();
                int t = Integer.parseInt(times);
                for (int i = 0; i < t; ++i) {
                    str.append(sb);
                }
                stack.add(str.toString());
                sb = new StringBuilder();
            }
        }

        return stack.pop();
    }


}
