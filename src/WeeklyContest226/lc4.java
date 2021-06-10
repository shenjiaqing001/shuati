package WeeklyContest226;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/31
 */
public class lc4 {
    Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();

    public boolean checkPartitioning(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (partition(c, 0, i)) {
                for (int j = i + 1; j < s.length(); ++j) {
                    if (partition(c, i + 1, j) && partition(c, j + 1, n - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean partition(char[] c, int i, int j) {
        if (map.containsKey(i) && map.get(i).containsKey(j)) return map.get(i).get(j);
        int a = i;
        int b = j;
        while (i < j) {
            if (c[i] != c[j]) {
                map.putIfAbsent(a, new HashMap<>());
                map.get(a).put(b, false);
                return false;
            }
            i++;
            j--;
        }
        map.putIfAbsent(a, new HashMap<>());
        map.get(a).put(b, false);
        return true;
    }
}
