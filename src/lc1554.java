import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/7
 */
public class lc1554 {
    public boolean differByOne(String[] dict) {
        int n = dict.length;
        long[] hash = new long[n];
        long base = 26;
        for (int i = 0; i < n; ++i) {
            long h = 0;
            for (char c : dict[i].toCharArray()) {
                h = h * 26 + c - 'a';
            }
            hash[i] = h;
        }


        int m = dict[0].length();
        long base_pow = 1;
        for (int i = m - 1; i >= 0; ++i) {
            Set<Long> set = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                long h = hash[j] - base_pow * (dict[j].charAt(i) - 'a');
                if (set.contains(h)) return true;
                set.add(h);
            }
            base_pow *= base;
        }
        return false;
    }
}
