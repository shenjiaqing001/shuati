package WeeklyContest275;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc2 {
    public int minSwaps(int[] nums) {
        // if (nums.length == 1) return 0;

        int count = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) count++;
        }
        int[] n = new int[nums.length * 2];
        for (int i = 0; i < nums.length; ++i) {
            n[i] = nums[i];
            n[i + nums.length] = nums[i];
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n.length; ++i) {
            sum += n[i];
            if (i >= count) {
                sum -= n[i - count];
            }
            if (i >= count - 1) {
                min = Math.min(min, count - sum);
            }
        }
        return min;
    }
}
