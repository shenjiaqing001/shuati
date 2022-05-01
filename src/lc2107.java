import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/15/22
 */
public class lc2107 {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        int count = map.size();
        int max = 0;
        for (int i = 0; i < candies.length; ++i) {
            map.put(candies[i], map.get(candies[i]) - 1);
            if (map.get(candies[i]) == 0) count--;
            if (i >= k) {
                if (map.get(candies[i - k]) == 0) count++;
                map.put(candies[i - k], map.get(candies[i - k]) + 1);
            }
            if (i >= k - 1) {
                max = Math.max(map.size() - count, max);
            }
        }
        return max;
    }
}
