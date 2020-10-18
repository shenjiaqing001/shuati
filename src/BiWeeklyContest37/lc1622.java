package BiWeeklyContest37;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class lc1622 {
    class Fancy {
        final int MOD = 1000000007;

        long exgcd(long a, long b, long[] x, long[] y) {
            if (b == 0) {
                x[0] = 1L;
                y[0] = 0L;
                return a;
            }
            long d = exgcd(b, a % b, x, y);
            long tmp = x[0];
            x[0] = y[0];
            y[0] = tmp - a / b * y[0];
            return d;
        }

        long inv(long a, long m) {
            long[] x = {0};
            long[] y = {0};
            long d = exgcd(a, m, x, y);
            if (d == 1) {
                return (x[0] % m + m) % m;
            }
            return -1;
        }

        long plus = 0;
        long multi = 1;
        ArrayList<Long> nums = new ArrayList<>();

        public Fancy() {

        }

        public void append(int val) {
            long c = inv(multi, MOD);
            long res = ((long) val + 1000000007 - plus) % 1000000007;
            res = res * c % 1000000007;
            nums.add(res);
        }

        public void addAll(int inc) {
            plus += inc;
            plus %= 1000000007;
        }

        public void multAll(int m) {
            plus *= m;
            plus %= 1000000007;
            multi *= m;
            multi %= 1000000007;
        }

        public int getIndex(int idx) {
            if (idx >= nums.size()) return 0;
            return (int) ((nums.get(idx) * multi % 1000000007 + plus) % 1000000007);
        }
    }
}
