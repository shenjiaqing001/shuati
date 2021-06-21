import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/15
 */
public class lc1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) stack.add(c);
            else {
                while (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}
