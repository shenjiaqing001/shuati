import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;
        int[] nHeights = new int[n + 1];
        for (int i = 0; i < n; ++i) nHeights[i] = heights[i];
        heights = nHeights;

        for (int i = 0; i <= n; ++i) {
            int h = heights[i];

            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int p = stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, heights[p] * i);
                    } else {
                        max = Math.max(max, heights[p] * (i - 1 - stack.peek()));
                    }
                }
                stack.add(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lc84 t = new lc84();
        int[] height = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(t.largestRectangleArea(height));

    }
}
