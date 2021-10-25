import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index1 = 0;
        int index2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (index1 < pushed.length && index2 < popped.length) {
            if (stack.isEmpty()) {
                stack.add(pushed[index1++]);
            } else {
                if (stack.peek() == popped[index2]) {
                    stack.pop();
                    index2++;
                } else {
                    stack.add(pushed[index1++]);
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != popped[index2]) {
                return false;
            }
            index2++;
            stack.pop();
        }
        return true;
    }
}
