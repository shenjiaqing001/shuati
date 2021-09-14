package WeeklyContest257;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1995 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) res++;
                    }
                }
            }
        }
        return res;
    }
}
