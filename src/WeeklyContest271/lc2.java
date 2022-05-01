package WeeklyContest271;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc2 {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            long max = nums[i];
            long min = nums[i];
            for (int j = i + 1; j < n; ++j) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += max - min;
            }
        }
        return res;
    }

    public long subArrayRanges2(int[] nums) {
        long max = 0;
        long min = 0;
        int n = nums.length;
        Deque<Integer> maxStack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();

        maxStack.add(-1);
        minStack.add(-1);
        for (int i = 0; i < n; ++i) {
            while (maxStack.peekLast() != -1 && nums[maxStack.peekLast()] <= nums[i]) {
                int index = maxStack.pollLast();
                max += (long) nums[index] * (i - index) * (index - maxStack.peekLast());
            }
            maxStack.addLast(i);

            while (minStack.peekLast() != -1 && nums[minStack.peekLast()] >= nums[i]) {
                int index = minStack.pollLast();
                max += (long) nums[index] * (i - index) * (index - minStack.peekLast());
            }
            minStack.addLast(i);
        }
        while (maxStack.peekLast() != -1) {
            int index = maxStack.pollLast();
            max += (long) nums[index] * (nums.length - index) * (index - maxStack.peekLast());
        }
        while (minStack.peekLast() != -1) {
            int index = minStack.pollLast();
            max += (long) nums[index] * (nums.length - index) * (index - minStack.peekLast());
        }
        System.out.println(max + " " + min);
        return max - min;
    }

}
