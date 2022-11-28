package WeeklyContest295;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/28/22
 */
public class lc3 {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int num : nums) {
            int tmpMax = 0;
            while (!stack.isEmpty() && num >= stack.peek()[0]) {
                int[] polled = stack.pop();
                tmpMax = Math.max(tmpMax, polled[1]);
                if (!stack.isEmpty()) {
                    stack.peek()[1] = Math.max(stack.peek()[1], tmpMax);
                }
            }
            if (!stack.isEmpty()) {
                stack.peek()[1]++;
                max = Math.max(max, stack.peek()[1]);
            }
            stack.add(new int[]{num, 0});
        }
        return max;
    }
}
