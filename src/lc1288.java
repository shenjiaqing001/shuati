import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/5
 */
public class lc1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] v : intervals) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }
}
