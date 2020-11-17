import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/16
 */
public class lc1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; ++i) {
            if (intervals[i][1] <= toBeRemoved[0]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
                res.add(tmp);
            } else if (intervals[i][0] >= toBeRemoved[1]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
                res.add(tmp);
            }
            if (intervals[i][0] < toBeRemoved[0] && toBeRemoved[0] < intervals[i][1]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(intervals[i][0]);
                tmp.add(toBeRemoved[0]);
                res.add(tmp);
            }
            if (intervals[i][0] < toBeRemoved[1] && toBeRemoved[1] < intervals[i][1]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(toBeRemoved[1]);
                tmp.add(intervals[i][1]);
                res.add(tmp);
            }
        }
        return res;
    }
}
