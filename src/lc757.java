import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/19
 */
public class lc757 {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals.length == 1) return 2;

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        int a = intervals[0][1] - 1;
        int b = intervals[0][1];
        int res = 2;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= a) continue;
            else if (intervals[i][0] > b) {
                a = intervals[i][1] - 1;
                b = intervals[i][1];
                res += 2;
            } else {
                a = b;
                b = intervals[i][1];
                if (a == b) a = a - 1;
                res += 1;
            }
        }
        return res;
    }
}
