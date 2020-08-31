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
            while (!max.isEmpty() && max.peekLast() < nums[i]) max.pollLast();
            while (!min.isEmpty() && min.peekLast() > nums[i]) min.pollLast();
            max.addLast(nums[i]);
            min.addLast(nums[i]);

            while (max.peekFirst() - min.peekFirst() > limit) {
                if (max.peekFirst() == nums[left]) max.pollFirst();
                if (min.peekFirst() == nums[left]) min.pollFirst();
                left++;
            }

            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
