package WeeklyContest281;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/19/22
 */
public class lc4 {
    public int gcd(int a, int b) {
        int tmp = 1;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public long coutPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long total = 0;
        for (int num : nums) {
            int g = gcd(num, k);
            map.put(g, map.getOrDefault(g, 0) + 1);
            if (((long) num * num) % (long) k == 0) total--;
        }
        Set<Integer> set = map.keySet();
        for (int num : nums) {
            for (int tmp : set) {
                if ((long) num * tmp % (long) k == 0) {
                    total += map.get(tmp);
                }
            }
        }
        return total;
    }
}
