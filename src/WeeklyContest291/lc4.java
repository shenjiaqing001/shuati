package WeeklyContest291;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/30/22
 */
public class lc4 {
    public long appealSum(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        long res = 0;
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < 26; ++i) {
            lists[i] = new ArrayList<>();
            lists[i].add(-1);
        }
        for (int i = 0; i < n; ++i) {
            lists[c[i] - 'a'].add(i);
        }
        for (int i = 0; i < 26; ++i) {
            if (lists[i].size() == 1) continue;
            for (int j = 1; j < lists[i].size(); ++j) {
                res += (long) (lists[i].get(j) - lists[i].get(j - 1)) *
                        (long) (n - lists[i].get(j));
            }
        }
        return res;
    }
}
