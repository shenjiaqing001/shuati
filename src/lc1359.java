/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/6/22
 */
public class lc1359 {
    public int countOrders(int n) {
        long res = 1;
        long mod = 1_000_000_007;
        for (int i = 2; i <= n; ++i) {
            res *= ((2L * i) * (2L * i - 1) / 2);
            res %= mod;
        }
        return (int) res;
    }
}
