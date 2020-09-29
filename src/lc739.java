import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/29
 */
public class lc739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; --i) {
            if (stack.size() == 0) {
                res[i] = 0;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
                if (!stack.isEmpty()) res[i] = stack.peek() - i;
                else res[i] = 0;
                stack.push(i);
            }
        }

        return res;
    }
}
