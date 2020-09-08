/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/8/20
 */
public class lc494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum) return 0;
        int[] count = new int[2 * sum + 1];
        count[sum] = 1;
        for (int num : nums) {
            int[] next = new int[2 * sum + 1];
            for (int i = 0; i < count.length; ++i) {
                if (count[i] != 0) {
                    next[i + num] += count[i];
                    next[i - num] += count[i];
                }
            }
            count = next;
        }
        return count[S + sum];
    }
}
