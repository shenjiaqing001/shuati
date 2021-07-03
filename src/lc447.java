import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; ++i) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i == j) continue;

                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
                res += 2 * map.get(dis) - 2;
            }
        }

        return res;
    }
}
