package WeeklyContest254;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc1969 {

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;
        long mod = 1_000_000_007;
        long num = 1;
        long res = 0;

        for (int i = 0; i < p; ++i) {
            res = (res + num) % mod;
            num = (num * 2) % mod;
        }

        long tmp = res - 1;
        tmp = (tmp + mod) % mod;

        for (int i = 1; i <= p - 1; ++i) {
            res = (res * tmp) % mod;
            tmp = (tmp * tmp) % mod;
        }
        return (int) res;
    }
}
