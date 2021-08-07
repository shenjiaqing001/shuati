import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/28
 */
public class lc1763 {
    String res = "";

    public String longestNiceSubstring(String s) {
        int lo = 0;
        int hi = s.length();

        for (int i = hi; i >= 0; --i) {
            if (check(i, s)) return res;
        }
        return "";
    }

    public boolean check(int length, String s) {
        int pairs = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < length; ++i) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                if ('a' <= c[i] && c[i] <= 'z') {
                    map.put(c[i], 1);
                    if (map.containsKey((char) ('A' + c[i] - 'a'))) pairs--;
                    else pairs++;
                } else {
                    map.put(c[i], 1);
                    if (map.containsKey((char) ('a' + c[i] - 'A'))) pairs--;
                    else pairs++;
                }
            }
        }
        if (pairs == 0) {
            res = s.substring(0, length);
            return true;
        }

        for (int i = length; i < c.length; ++i) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                if ('a' <= c[i] && c[i] <= 'z') {
                    map.put(c[i], 1);
                    if (map.containsKey((char) ('A' + c[i] - 'a'))) pairs--;
                    else pairs++;
                } else {
                    map.put(c[i], 1);
                    if (map.containsKey((char) ('a' + c[i] - 'A'))) pairs--;
                    else pairs++;
                }
            }

            map.put(c[i - length], map.get(c[i - length]) - 1);
            if (map.get(c[i - length]) == 0) {
                map.remove(c[i - length]);
                if ('a' <= c[i - length] && c[i - length] <= 'z') {
                    if (map.containsKey((char) (c[i - length] + 'A' - 'a'))) {
                        pairs++;
                    } else {
                        pairs--;
                    }
                } else {
                    if (map.containsKey((char) (c[i - length] + 'a' - 'A'))) {
                        pairs++;
                    } else {
                        pairs--;
                    }
                }
            }
            if (pairs == 0) {
                res = s.substring(i - length + 1, i + 1);
                return true;
            }
        }
        return false;
    }


}
