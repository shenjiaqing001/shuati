package BiWeeklyContest61;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/18
 */
public class lc2007 {
    public int[] findOriginalArray(int[] changed) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : changed) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        for (Integer key : treeMap.keySet()) {
            int num = treeMap.get(key);
            if (treeMap.get(key) == 0) continue;
            if (!treeMap.containsKey(2 * key) || treeMap.get(2 * key) < num) return new int[]{};
            if (key == 0) {
                if (num % 2 != 0) return new int[]{};
                num /= 2;
            }
            for (int i = 0; i < num; ++i) list.add(key);
            treeMap.put(2 * key, treeMap.get(2 * key) - num);
        }
        int[] res = new int[changed.length / 2];
        for (int i = 0; i < changed.length / 2; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
