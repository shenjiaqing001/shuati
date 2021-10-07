import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!max.isEmpty() && nums[max.peekLast()] < nums[i]) max.pollLast();
            while (!min.isEmpty() && nums[min.peekLast()] > nums[i]) min.pollLast();
            max.addLast(i);
            min.addLast(i);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if (max.peekFirst() == left) max.pollFirst();
                if (min.peekFirst() == left) min.pollFirst();
                left++;
            }

            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
