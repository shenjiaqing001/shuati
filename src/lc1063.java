import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/15
 */
public class lc1063 {
    public int validSubarrays(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                res += i - deque.pollLast();
            }
            deque.addLast(i);
        }
        while (!deque.isEmpty()) res += nums.length - deque.pollLast();
        return res;
    }
}
