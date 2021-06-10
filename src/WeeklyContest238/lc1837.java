package WeeklyContest238;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/25
 */
public class lc1837 {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n != 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}
