import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/12
 */
public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            System.out.println(key);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) res.add(list);
        return res;
    }
}
