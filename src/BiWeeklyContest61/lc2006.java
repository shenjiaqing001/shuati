package BiWeeklyContest61;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/18
 */
public class lc2006 {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (Math.abs(nums[i] - nums[j]) == k) res++;
            }
        }
        return res;
    }
}
