import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/9
 */
public class lc1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k)
                deque.pollFirst();
            if (deque.isEmpty() || dp[deque.peekFirst()] <= 0) {
                deque.clear();
                deque.add(i);
                dp[i] = nums[i];
            } else {
                dp[i] = dp[deque.peekFirst()] + nums[i];
                while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i])
                    deque.pollLast();
                deque.add(i);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        lc1425 test = new lc1425();
        test.constrainedSubsetSum(new int[]{-5266, 4019, 7336, -3681, -5767}, 2);
    }
}
