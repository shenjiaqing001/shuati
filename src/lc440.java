/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/9
 */
public class lc440 {
    public int findKthNumber(int n, int k) {
        if (k == 1) return 1;
        long res, i;

        for (i = 1; i <= 9; ++i) {
            long zero = 1;
            long tmp = i;
            long sum = 0;
            while ((tmp + 1) * zero <= n + 1) {
                sum += zero;
                zero *= 10;
            }
            if (tmp * zero <= n) {
                sum += n + 1 - tmp * zero;
            }
            if (sum >= k) break;
            k -= sum;
        }

        res = i;
        if (k == 1) return (int) res;
        k -= 1;

        while (k > 0) {
            for (i = 0; i <= 9; ++i) {
                long zero = 1;
                long tmp = i;
                long sum = 0;
                while (res * zero * 10 + (tmp + 1) * zero <= n + 1) {
                    sum += zero;
                    zero *= 10;
                }
                if (res * zero * 10 + tmp * zero <= n) {
                    sum += n + 1 - tmp * zero - res * zero * 10;
                }
                if (sum >= k) break;
                k -= sum;
            }


            res = res * 10 + i;
            if (k == 1) return (int) res;
            k -= 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        lc440 t = new lc440();
        System.out.println(t.findKthNumber(681692778,
                351251360));
    }
}
