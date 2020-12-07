package WeeklyContest218;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/7
 */
public class lc1680 {
    public int concatenatedBinary(int n) {
        long res = 0, mul = 1;
        int mod = 1_000_000_007;
        for (int i = n; i > 0; --i) {
            int no = i;
            while (no > 0) {
                if (no % 2 == 1) res = (res + mul) % mod;
                no >>= 1;
                mul = (mul << 1) % mod;
            }
        }

        return (int) res;
    }
}
