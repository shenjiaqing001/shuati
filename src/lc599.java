import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/19
 */
public class lc599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                set.add(list2[i]);
                map.put(list2[i], map.get(list2[i]) + i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (String str : set) {
            min = Math.min(min, map.get(str));
        }
        List<String> res = new ArrayList<>();
        for (String str : map.keySet()) {
            if (set.contains(str) && map.get(str) == min) {
                res.add(str);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
