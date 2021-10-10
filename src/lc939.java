import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc939 {
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        int min = 16 * 1_000_000_00;
        for (int[] point : points) {
            map.putIfAbsent(point[0], new TreeSet<>());
            map.get(point[0]).add(point[1]);
        }
        for (Integer x1 : map.keySet()) {
            Integer x2 = map.ceilingKey(x1 + 1);
            while (x2 != null) {
                TreeSet<Integer> set = map.get(x1);
                for (Integer y1 : set) {
                    Integer y2 = set.ceiling(y1 + 1);
                    while (y2 != null) {
                        if (map.get(x2).contains(y1) && map.get(x2).contains(y2)) {
                            int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                            min = Math.min(min, area);
                        }
                        y2 = set.ceiling(y2 + 1);
                    }
                }
                x2 = map.ceilingKey(x2 + 1);
            }
        }
        if (min == 16 * 1_000_000_00) return 0;
        else return min;
    }
}
