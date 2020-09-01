import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc1399 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; ++i) {
            int tmp = helper(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int max = 0;
        for (Integer num : map.values()) {
            max = Math.max(num, max);
        }

        int count = 0;
        for (Integer num : map.values()) {
            if (num == max) count++;
        }
        return count;
    }

    public int helper(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
