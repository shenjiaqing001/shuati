import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/31
 */
public class lc42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; ++i) {
            if (stack.isEmpty() || height[i] < height[stack.peekLast()]) stack.add(i);
            else {
                while (!stack.isEmpty() && height[i] >= height[stack.peekLast()]) {
                    int low = height[stack.pollLast()];
                    if (stack.isEmpty()) break;
                    res += (i - stack.peekLast() - 1) *
                            (Math.min(height[stack.peekLast()], height[i]) - low);
                    if (height[stack.peekLast()] <= height[i]) {
                        continue;
                    } else {
                        break;
                    }
                }
                stack.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc42 test = new lc42();
        test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
