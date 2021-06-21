package BiWeeklyContest54;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/12
 */
public class lc1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = chalk[i - 1] + sum[i - 1];
        }

        k %= sum[n];
        for (int i = 1; i <= n; ++i) {
            if (k < sum[i]) return i - 1;
        }
        return 0;
    }
}
