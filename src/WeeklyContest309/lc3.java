package WeeklyContest309;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/3/22
 */
public class lc3 {
    public boolean check(int[] ans, int[] tmp) {
        for (int i = 0; i < 32; ++i) {
            if (ans[i] == 1 && tmp[i] == 1) {
                return false;
            }
        }
        return true;
    }


    public int longestNiceSubarray(int[] nums) {
        int max = 0;
        int[] ans = new int[35];
        int left = 0;
        for (int i = 0; i < nums.length; ++i) {
            int[] tmp = new int[32];
            for (int j = 0; j < 32; ++j) {
                if ((nums[i] & (1 << j)) > 0) {
                    tmp[j] = 1;
                }
            }
            while (!check(ans, tmp)) {
                for (int j = 0; j < 32; ++j) {
                    if ((nums[left] & (1 << j)) > 0) {
                        ans[j] -= 1;
                    }
                }
                left++;
            }
            for (int j = 0; j < 32; ++j) {
                ans[j] += tmp[j];
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
