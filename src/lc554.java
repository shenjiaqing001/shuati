import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/22
 */
public class lc554 {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int n : wall.get(0)) {
            sum += n;
        }
        for (List<Integer> w : wall) {
            int tmp = 0;
            for (Integer num : w) {
                tmp += num;
                if (tmp != sum) {
                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                    max = Math.max(max, map.get(tmp));
                }
            }
        }
        return wall.size() - max;
    }
}
