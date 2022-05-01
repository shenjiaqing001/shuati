package WeeklyContest273;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc4 {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length / 2];
        TreeMap<Integer, Integer> tmp = new TreeMap<>();


        for (int i = 0; i < nums.length; ++i) {
            tmp.put(nums[i], tmp.getOrDefault(nums[i], 0) + 1);
        }

        Integer key = tmp.ceilingKey(tmp.firstKey() + 1);
        while (key != null) {
            if ((key - tmp.firstKey()) % 2 != 0) {
                key = tmp.ceilingKey(key + 1);
                continue;
            }
            int maxKey = (key - tmp.firstKey()) / 2;
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(tmp);
            int index = 0;
            System.out.println(maxKey);

            while (true) {
                int num = treeMap.firstKey();
                int howMany = treeMap.get(num);
                if (!treeMap.containsKey(num + 2 * maxKey) ||
                        treeMap.get(num + 2 * maxKey) < howMany) break;
                treeMap.put(num + 2 * maxKey, treeMap.get(num + 2 * maxKey) - howMany);
                if (treeMap.get(num + 2 * maxKey) == 0) treeMap.remove(num + 2 * maxKey);
                for (int i = index; i < index + howMany; ++i) {
                    res[i] = num + maxKey;
                }
                index += howMany;
                treeMap.remove(num);
                if (index == res.length) break;
            }
            if (index == res.length) break;
            key = tmp.ceilingKey(key + 1);
        }
        return res;
    }
}
