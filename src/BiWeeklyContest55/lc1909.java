package BiWeeklyContest55;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/26
 */
public class lc1909 {
    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            boolean loop = true;
            for (int j = 1; j < nums.length; ++j) {
                if (j == i) continue;
                int last = j - 1;
                if (j - 1 == i) last = j - 2;
                if (last < 0) continue;

                if (nums[j] <= nums[last]) {
                    loop = false;
                    break;
                }
            }
            if (loop) return true;
        }

        return false;
    }
}
