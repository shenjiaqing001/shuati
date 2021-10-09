import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/5
 */
public class lc402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.add(c);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
