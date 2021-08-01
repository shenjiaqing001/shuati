package WeeklyContest252;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/31
 */
public class lc1952 {
    public boolean isThree(int n) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) sum++;
        }
        return sum == 3;
    }
}
