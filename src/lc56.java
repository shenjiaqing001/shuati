import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/19
 */
public class lc56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));

        int[] now;
        List<int[]> result = new ArrayList<>();
        now = intervals[0];
        result.add(now);
        for (int i = 1; i < intervals.length; ++i) {
            if (now[1] >= intervals[i][0]) {
                now[1] = Math.max(intervals[i][1], now[1]);
            } else {
                now = intervals[i];
                result.add(now);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
