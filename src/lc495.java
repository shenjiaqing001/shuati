/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int res = 0;
        int max = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            int now = timeSeries[i] + duration;
            res += now - Math.max(max, timeSeries[i]);
            max = now;
        }
        return res;
    }
}
