package WeeklyContest258;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();
        for (int[] rechtangle : rectangles) {
            double rate = (double) rechtangle[0] / (double) rechtangle[1];
            map.put(rate, map.getOrDefault(rate, 0) + 1);
        }
        long res = 0;
        for (Integer num : map.values()) {
            if (num == 1) continue;
            res += ((long) num * (long) (num - 1)) / 2;
        }
        return res;
    }
}
