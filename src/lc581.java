import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/15
 */
public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> small = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            while (!small.isEmpty() && nums[small.peek()] > nums[i]) {
                min = Math.min(min, small.pop());
            }
            small.add(i);
        }


        Stack<Integer> big = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!big.isEmpty() && nums[big.peek()] < nums[i]) {
                max = Math.max(max, big.pop());
            }
            big.add(i);
        }
        if(max == Integer.MIN_VALUE) return 0;
        return max - min + 1;
    }
}
