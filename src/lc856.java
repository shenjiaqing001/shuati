import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/17/22
 */
public class lc856 {
    public int scoreOfParentheses(String s) {
        int tmp = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(tmp);
                tmp = 0;
            } else {
                tmp = stack.pollLast() + Math.max(2 * tmp, 1);
            }
        }
        return tmp;
    }
}
