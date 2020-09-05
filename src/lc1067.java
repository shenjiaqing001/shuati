/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc1067 {
    public int digitsCount(int d, int low, int high) {
        return count(d, high) - count(d, low - 1);
    }


    public int count(int digit, int bound) {
        int res = 0;
        for (long i = 1; i <= bound; i *= 10) {
            long a = bound / i;
            long b = bound % i;
            res += (a + 9 - digit) / 10 * i;
            res += (a % 10 == digit ? b + 1 : 0);
            if (digit == 0)
                res -= i;
            System.out.println(res);
        }
        return res;
    }
}
