import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc436 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            if (entry == null)
                res[i] = -1;
            else
                res[i] = entry.getValue();
        }
        return res;
    }
}
