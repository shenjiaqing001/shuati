package WeeklyContest214;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/8
 */
public class lc5562 {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if(count[i] == 0) continue;
            if (!set.contains(count[i])) set.add(count[i]);
            else {
                int k = count[i];
                while (k>0 && set.contains(k)) k--;
                res += count[i] - k;
                set.add(k);
            }
        }
        return res;
    }
}
