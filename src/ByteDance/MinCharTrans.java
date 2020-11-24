package ByteDance;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/23
 */
public class MinCharTrans {
    public static int solve(String source, String target) {
        if (source.equals(target)) return 0;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < source.length(); ++i) {
            if (dp.getOrDefault(source.charAt(i), target.charAt(i)) != target.charAt(i))
                return -1;
            dp.put(source.charAt(i), target.charAt(i));
        }
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (Character key : dp.keySet()) {
            if (key != dp.get(key)) {
                res++;
                if (dfs(dp, set, key)) res++;
            }
        }
        return res;
    }

    public static boolean dfs(Map<Character, Character> dp, Set<Character> set, Character c) {
        if (set.contains(c)) return false;
        Set<Character> tmp = new HashSet<>();
        while (true) {
            if (tmp.contains(c)) return true;
            if (!dp.containsKey(c) || set.contains(c) || dp.get(c) == c) return false;
            set.add(c);
            tmp.add(c);
            c = dp.get(c);
        }
    }


    public static void main(String[] args) {
        System.out.println(solve("aaaabbb", "bbbbaaa"));
    }
}
