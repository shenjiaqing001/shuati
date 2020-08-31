import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/12/20
 */
public class lc150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; ++i) {
            try {
                int num = Integer.valueOf(tokens[i]);
                stack.add(num);
            } catch (Exception e) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (tokens[i].equals("+"))
                    stack.add(num1 + num2);
                if (tokens[i].equals("-"))
                    stack.add(num1 - num2);
                if (tokens[i].equals("*"))
                    stack.add(num1 * num2);
                if (tokens[i].equals("/"))
                    stack.add(num1 / num2);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("-123"));
    }
}
