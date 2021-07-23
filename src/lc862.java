import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/7
 */
public class lc862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int min = n + 1;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i <= n; ++i) {
            while (!deque.isEmpty() && sum[deque.peekFirst()] + k <= sum[i]) {
                min = Math.min(min, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        if (min == n + 1) return -1;
        return min;
    }
}
