import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/21
 */
public class lc20 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.add(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
