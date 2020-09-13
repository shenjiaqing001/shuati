import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        List<int[]> res = new LinkedList<>();

        int i = 0;
        if (newInterval[1] < intervals[0][0]) {
            res.add(newInterval);
            for (int[] interval : intervals) res.add(interval);
            return res.toArray(new int[res.size()][]);
        }

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        if (i == intervals.length) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        int begin = Math.min(newInterval[0], intervals[i][0]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) i++;
        int end = Math.max(newInterval[1], intervals[i - 1][1]);
        res.add(new int[]{begin, end});
        while (i < intervals.length) res.add(intervals[i++]);
        return res.toArray(new int[res.size()][]);
    }
}
