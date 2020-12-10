import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/10
 */
public class lc1124 {
    public int longestWPI(int[] hours) {
        if (hours.length == 0) return 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;

        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (sum > 0) {
                maxLen = i + 1;
            } else if (map.containsKey(sum -
                    1)) {
                maxLen = Math.max(maxLen, i - map.get(sum - 1));
            }
        }

        return maxLen;
    }
}
