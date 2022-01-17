/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/12/11
 */
public class lc878 {
    public int gcd(int a, int b) {
        int tmp = 1;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int nthMagicalNumber(int n, int a, int b) {
        long lo = 1;
        long hi = (long) 1e14;
        int gcd = gcd(a, b);
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            long nth = mid / a + mid / b - mid / (a * b / gcd);
            if (nth < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }

        }
        return (int) (lo % 1_000_000_007l);
    }
}
