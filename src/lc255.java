import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/5
 */
public class lc255 {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int smallest = 0;
        for (int num : preorder) {
            if (num < smallest) return false;
            while (!stack.isEmpty() && stack.peekLast() < num) {
                smallest = stack.pollLast();
            }
            stack.addLast(num);
        }
        return true;
    }
}
