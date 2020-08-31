import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) q.pollLast();
            q.addLast(new int[]{i, nums[i]});
        }
        int[] res = new int[nums.length - k + 1];
        int now = 0;
        res[now++] = q.peekFirst()[1];
        for (int i = k; i < nums.length; ++i) {
            if (q.peekFirst()[0] + k == i) {
                q.pollFirst();
            }
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) q.pollLast();
            q.addLast(new int[]{i, nums[i]});
            res[now++] = q.peekFirst()[1];
        }
        return res;
    }
}
