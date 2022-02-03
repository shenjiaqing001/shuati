package mock.year2021.day1113;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class q1 {
    //现在给两个长度相同的字符串s和t，10^5，仅包含小写字母，最多允许交换一次，问最多能有多少个匹配对，s[i] = t[i]


    public int solve(String s, String t) {
        int res = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Set<Character>> map = new HashMap<>();
        boolean[] flag = new boolean[26];
        int max = 0;
        for (int i = 0; i < sChars.length; ++i) {
            if (sChars[i] == tChars[i]) {
                res++;
            } else {
                map.putIfAbsent(sChars[i], new HashSet<>());
                map.get(sChars[i]).add(tChars[i]);
                if (map.containsKey(tChars[i]) && map.get(tChars[i]).contains(sChars[i])) max = 2;
                if (map.containsKey(tChars[i]) || flag[tChars[i] - 'a']) max = Math.max(max, 1);
                flag[tChars[i] - 'a'] = true;
            }
        }
        return res + max;
    }
}
