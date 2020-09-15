/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/16/20
 */
public class lc213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int dp0 = 0;
        int dp1 = 0;

        for (int i = 1; i < nums.length; ++i) {
            int next0 = Math.max(dp0, dp1);
            int next1 = dp0 + nums[i];
            dp0 = next0;
            dp1 = next1;
        }
        int res = Math.max(dp0, dp1);

        dp0 = 0;
        dp1 = nums[0];
        for (int i = 1; i < nums.length - 1; ++i) {
            int next0 = Math.max(dp0, dp1);
            int next1 = dp0 + nums[i];
            dp0 = next0;
            dp1 = next1;
        }
        res = Math.max(Math.max(res, dp0), dp1);
        return res;
    }
}
