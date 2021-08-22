import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/22
 */
public class lc850 {
    public static void main(String[] args) {

    }

    public int rectangleArea(int[][] rectangles) {
        TreeMap<Long, List<Long[]>> map = new TreeMap<>();
        for (int[] rectangle : rectangles) {
            map.putIfAbsent((long) rectangle[0], new ArrayList<>());
            map.get((long) rectangle[0]).add(new Long[]{
                    (long) rectangle[1], (long) rectangle[2], (long) rectangle[3]}
            );
            map.putIfAbsent((long) rectangle[2], new ArrayList<>());
        }
        long res = 0;
        while (map.size() > 1) {
            Map.Entry<Long, List<Long[]>> entry = map.pollFirstEntry();
            long left = entry.getKey();
            long right = map.firstKey();

            List<Long[]> list = entry.getValue();
            if (list.size() == 0) continue;
            list.sort((o1, o2) -> Long.compare(o1[0], o2[0]));
            long bot = list.get(0)[0];
            for (Long[] rect : list) {
                if (rect[1] > right) {
                    map.get(right).add(rect);
                }
                if (rect[2] <= bot) continue;
                bot = Math.max(bot, rect[0]);
                res += (right - left) * (rect[2] - bot);
                bot = rect[2];
            }
        }

        return (int) (res % 1_000_000_007);
    }
}
