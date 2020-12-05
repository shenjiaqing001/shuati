package WeeklyContest217;

import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/5
 */
public class lc1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; ++i) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] &&
                    nums.length - i + stack.size() > k) {
                stack.pop();
            }

            if (stack.size() < k) stack.add(i);
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            res[i] = nums[stack.pop()];
        }
        return res;
    }
}
