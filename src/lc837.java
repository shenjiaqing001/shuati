/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/7
 */
public class lc837 {
    public static void main(String[] args) {
        System.out.println(1.0 / 55);
        int maxPts = 10;
        double prob = (1.0 / ((maxPts) * (maxPts + 1) / 2));
        System.out.println(prob);

    }

    public double new21Game(int n, int k, int maxPts) {
        double remain = 1;
        double res = 0;
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = remain / maxPts;
            if (i < k) remain += dp[i];
            else res += dp[i];
            if (i >= maxPts) {
                remain -= dp[i - maxPts];
            }
        }
        return res;
    }
}
