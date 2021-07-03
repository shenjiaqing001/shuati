import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && deque.peekLast()[1] < nums[i]) deque.pollLast();
            deque.offerLast(new int[]{i, nums[i]});
        }

        int[] res = new int[nums.length - k + 1];
        int pos = 0;

        res[pos++] = deque.peekFirst()[1];
        for (int i = k; i < nums.length; ++i) {
            while (!deque.isEmpty() && deque.peekFirst()[0] <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast()[1] < nums[i]) deque.pollLast();
            deque.offer(new int[]{i, nums[i]});
            res[pos++] = deque.peekFirst()[1];
        }

        return res;
    }
}
