package WeeklyContest309;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/3/22
 */
public class lc2 {
    public int numberOfWays(int startPos, int endPos, int k) {
        long[] array = new long[3005];
        int offset = 1000;
        long mod = 1_000_000_007;
        // 0 = 1000
        array[startPos + offset] = 1;
        for (int i = 0; i < k; ++i) {
            long[] next = new long[3005];
            for (int j = 0; j <= 3000; ++j) {
                if (j != 0) {
                    next[j] += array[j - 1];
                }
                if (j != 3000) {
                    next[j] += array[j + 1];
                }
                next[j] %= mod;
            }
            array = next;
        }
        return (int) array[endPos + offset];
    }
}
