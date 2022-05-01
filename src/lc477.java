/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/26/22
 */
public class lc477 {
    public int totalHammingDistance(int[] nums) {
        int[][] dp = new int[32][2];
        for (int num : nums) {
            for (int i = 0; i < 32; ++i) {
                if ((num & (1 << i)) != 0) {
                    dp[i][1]++;
                } else {
                    dp[i][0]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += dp[i][0] * dp[i][1];
        }

        return res;
    }
}
