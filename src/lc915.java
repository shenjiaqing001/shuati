import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/22
 */
public class lc915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int leftMax = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (deque.isEmpty() || nums[i] < nums[deque.peekLast()]) deque.addLast(i);
        }


        for (int i = 0; i < n; ++i) {
            leftMax = Math.max(leftMax, nums[i]);
            if (deque.peekLast() == i) deque.pollLast();
            if (deque.isEmpty()) return i + 1;
            if (leftMax <= nums[deque.peekLast()]) return i + 1;
        }
        return n;
    }

    public static void main(String[] args) {
        lc915 test = new lc915();
        test.partitionDisjoint(new int[]{5,0,3,8,6});
    }
}
