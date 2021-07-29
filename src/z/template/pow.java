package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/4
 */
public class pow {
    private static int pow(int n, int m) {
        int res = 1;
        int base = n;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = (res * base) % 1_000_000_007;
            }
            base = (base * base) % 1_000_000_007;
            m = m >> 1;
        }
        return res;
    }
}
