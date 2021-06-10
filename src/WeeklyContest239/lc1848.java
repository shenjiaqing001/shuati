package WeeklyContest239;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(start - i));
            }
        }
        return min;
    }
}
