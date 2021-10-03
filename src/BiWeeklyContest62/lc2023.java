package BiWeeklyContest62;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2023 {
    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i == j) continue;
                if ((nums[i] + nums[j]).equals(target)) res++;
            }
        }
        return res;
    }
}
