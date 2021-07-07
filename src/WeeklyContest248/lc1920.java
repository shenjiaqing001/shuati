package WeeklyContest248;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc1920 {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; ++i) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
