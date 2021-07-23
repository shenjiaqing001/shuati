/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/15
 */
public class lc370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] dp = new int[length + 1];
        for (int[] update : updates) {
            dp[update[0]] += update[2];
            dp[update[1] + 1] -= update[2];
        }
        int[] res = new int[length];
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            sum += dp[i];
            res[i] = sum;
        }
        return res;
    }
}
