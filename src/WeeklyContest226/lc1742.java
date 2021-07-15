package WeeklyContest226;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/31
 */
public class lc1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; ++i) {
            int sum = 0;
            int tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        return max;
    }
}
