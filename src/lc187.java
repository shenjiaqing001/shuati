import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/18/20
 */
public class lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 9; i < s.length(); ++i) {
            String tmp = s.substring(i - 9, i + 1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (map.get(tmp) == 2)
                res.add(tmp);
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        long base = 26;
        List<String> res = new LinkedList<>();
        if (s.length() < 10) return res;
        Set<Long> set = new HashSet<>();
        Set<Long> resSet = new HashSet<>();
        long hash = 0;
        long pow_base = 1;
        char[] c = s.toCharArray();
        for (int i = 1; i < 10; ++i) pow_base *= base;
        for (int i = 0; i < 10; ++i) hash = base * hash + c[i] - 'a';
        set.add(hash);
        for (int i = 10; i < c.length; ++i) {
            hash -= pow_base * (c[i - 10] - 'a');
            hash = 26 * hash + c[i] - 'a';
            if (set.contains(hash)) {
                if (!resSet.contains(hash)) {
                    res.add(s.substring(i - 10 + 1, i + 1));
                    resSet.add(hash);
                }
            } else {
                set.add(hash);
            }
        }
        return res;
    }
}
