package WeeklyContest248;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc1922 {

    static final int mod = 1_000_000_007;

    public int countGoodNumbers(long n) {
        if (n == 1) return 5;
        if (n % 2 == 0) {
            //4^(n/2+1) ^ 5^(n/2-1)
            long a = pow(4, n / 2);
            long b = pow(5, n / 2);
            return (int) ((a * b) % mod);
        } else {

            // 4^(n/2+1) * 5^(n/2)

            long a = pow(4, n / 2 + 1);
            long b = pow(5, n / 2);
            return (int) ((a * b) % mod);
        }
    }


    private static long pow(long n, long m) {
        long res = 1;
        long base = n;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            m = m >> 1;
        }
        return res;
    }
}
