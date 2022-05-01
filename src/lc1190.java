import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/5/22
 */
public class lc1190 {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.addLast(new StringBuilder());
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(new StringBuilder());
            } else if (c == ')') {
                StringBuilder sb = stack.pollLast();
                stack.getLast().append(sb.reverse());
            } else {
                stack.getLast().append(c);
            }
        }
        return stack.getLast().toString();
    }
}
