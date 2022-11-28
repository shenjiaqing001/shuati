package WeeklyContest315;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/15/22
 */
public class lc3 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; ++i) {
            int tmp = i;
            int res = 0;
            while (tmp > 0) {
                res *= 10;
                res += tmp % 10;
                tmp /= 10;
            }
            if (i + res == num) return true;
        }
        return false;
    }
}
