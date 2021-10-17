/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/7
 */
public class lc837 {
    public static void main(String[] args) {
        lc837 test = new lc837();
        test.new21Game(21, 17, 10);
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1;
        double remain = 1;
        double res = 0;
        double[] dp = new double[k + maxPts];
        dp[0] = 1;
        for (int i = 1; i <= k + maxPts - 1; ++i) {
            dp[i] = remain / maxPts;
            if (i < k) remain += dp[i];
            if (i >= k && i <= n) res += dp[i];
            if (i >= maxPts) {
                remain -= dp[i - maxPts];
            }
        }
        return res;
    }
}
