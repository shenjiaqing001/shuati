import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        int res = 1;
        int last = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < last) continue;
            res++;
            last = intervals[i][1];
        }
        return intervals.length - res;
    }
}
