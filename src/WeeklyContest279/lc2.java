package WeeklyContest279;

import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/5/22
 */
public class lc2 {
    public long smallestNumber(long num) {
        if (num == 0) return 0;
        if (num > 0) {
            TreeMap<Long, Integer> map = new TreeMap();
            while (num != 0) {
                long cur = num % 10;
                num /= 10;
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            long res = 0;
            for (long i = 1; i <= 9; ++i) {
                if (map.containsKey(i)) {
                    res = res * 10 + i;
                    map.put(i, map.get(i) - 1);
                    if (map.get(i) == 0) map.remove(i);
                    break;
                }
            }
            while (!map.isEmpty()) {
                for (long i = 0; i <= 9; ++i) {
                    if (map.containsKey(i)) {
                        res = res * 10 + i;
                        map.put(i, map.get(i) - 1);
                        if (map.get(i) == 0) map.remove(i);
                        break;
                    }
                }
            }
            return res;
        } else {
            num = -num;
            TreeMap<Long, Integer> map = new TreeMap();
            while (num != 0) {
                long cur = num % 10;
                num /= 10;
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            long res = 0;
            while (!map.isEmpty()) {
                for (long i = 9; i >= 0; --i) {
                    if (map.containsKey(i)) {
                        res = res * 10 + i;
                        map.put(i, map.get(i) - 1);
                        if (map.get(i) == 0) map.remove(i);
                        break;
                    }
                }
            }
            return -res;
        }
    }
}
