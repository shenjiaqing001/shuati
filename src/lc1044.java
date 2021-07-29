import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class lc1044 {
    String res = "";

    public String longestDupSubstring(String S) {
        int lo = 0;
        int hi = S.length() - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(S, mid + 1)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return res;
    }

    public boolean check(String s, int length) {
        long base = 31;

        long pow_base = 1;
        long hash = 0;
        // long mod = (long) 1_000_003 * 1_000_003 + 7;
        for (int i = 0; i < length; ++i) pow_base = pow_base * base;
        // for (int i = 0; i < length; ++i) pow_base = pow_base * base % mod;
        Set<Long> set = new HashSet<>();

        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            hash = (hash * base + c[i] - 'a');
            // hash = (hash * base % mod + c[i] - 'a') % mod;
            if (i >= length) {
                hash = (hash - pow_base * (c[i - length] - 'a'));
                // hash = ((hash - pow_base * (c[i - length] - 'a') % mod) % mod + mod) % mod;
            }

            if (i >= length - 1) {
                if (set.contains(hash)) {
                    res = s.substring(i - length + 1, i + 1);
                    return true;
                }
                set.add(hash);
            }
        }
        return false;
    }
}
