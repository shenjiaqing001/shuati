package WeeklyContest317;

import java.security.KeyPair;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/29/22
 */
public class lc2 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < creators.length; ++i) {
            map.put(creators[i], map.getOrDefault(creators[i], 0) + views[i]);
        }
        int max = 0;
        Map<String, String> creatorIdMap = new HashMap<>();
        Map<String, Integer> viewsMap = new HashMap<>();
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        Set<String> set = new HashSet<>();
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                set.add(key);
            }
        }
        for (int i = 0; i < creators.length; ++i) {
            if (set.contains(creators[i])) {
                if (!viewsMap.containsKey(creators[i]) || viewsMap.get(creators[i]) < views[i]) {
                    viewsMap.put(creators[i], views[i]);
                    creatorIdMap.put(creators[i], ids[i]);
                } else if (viewsMap.get(creators[i]) == views[i] &&
                        creatorIdMap.get(creators[i]).compareTo(ids[i]) > 0) {
                    viewsMap.put(creators[i], views[i]);
                    creatorIdMap.put(creators[i], ids[i]);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : creatorIdMap.keySet()) {
            List<String> tmp = new ArrayList<>();
            tmp.add(key);
            tmp.add(creatorIdMap.get(key));
            res.add(tmp);
        }
        return res;
    }
}
