package WeeklyContest297;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/11/22
 */
public class lc4 {
    public long distinctNames(String[] ideas) {
        long[] startWith = new long[26];
        Map<String, long[]> map = new HashMap<>();
        int n = ideas.length;
        long res = 0;
        for (String s : ideas) {
            char c = s.charAt(0);
            String suffix = s.substring(1);
            startWith[c - 'a']++;
            map.putIfAbsent(suffix, new long[26]);
            map.get(suffix)[c - 'a']++;
        }
        for (String s : ideas) {
            char c = s.charAt(0);
            String suffix = s.substring(1);
            res += n;
            long[] tmp = map.get(suffix);
            for (int i = 0; i < 26; ++i) {
                if (tmp[i] > 0) {
                    if (i == c - 'a') {
                        res -= startWith[i];
                    } else {
                        res -= (2L * (startWith[i] - tmp[i] - startWith[i] + 1) + tmp[i]);
                    }
                }
            }
        }
        return res;
    }
}
