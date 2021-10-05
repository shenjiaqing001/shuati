import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.addLast(i);
        }

        int[] res = new int[nums.length - k + 1];
        int pos = 0;

        res[pos++] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[deque.peekFirst()] <= i - k) deque.pollFirst();
            if (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.addLast(i);
            res[pos++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
