package WeeklyContest317;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/29/22
 */
public class lc3 {
    public long makeIntegerBeautiful(long n, int target) {
        long res = 0;
        while (true) {
            int sum = 0;
            long tmp = n;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum <= target) break;
            tmp = n;
            long count = 1;
            while (tmp % 10 == 0) {
                tmp /= 10;
                count *= 10;
            }
            long tt = (10 - tmp % 10) * count;
            res += tt;
            n += tt;
        }
        return res;
    }
}
