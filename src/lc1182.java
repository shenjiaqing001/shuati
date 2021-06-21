import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/17
 */
public class lc1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        TreeSet<Integer>[] set = new TreeSet[4];
        for (int i = 1; i <= 3; ++i) {
            set[i] = new TreeSet<>();
        }

        for (int i = 0; i < colors.length; ++i) {
            set[colors[i]].add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int index = query[0];
            int color = query[1];
            int min = Integer.MAX_VALUE;
            if (set[color].ceiling(index) != null) {
                min = Math.min(min, set[color].ceiling(index) - index);
            }
            if (set[color].floor(index) != null) {
                min = Math.min(min, index - set[color].floor(index));
            }
            if (min == Integer.MAX_VALUE) min = -1;
            res.add(min);
        }
        return res;
    }
}
