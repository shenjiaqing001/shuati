import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/11
 */
public class lc954 {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> positiveMap = new TreeMap<>();
        TreeMap<Integer, Integer> negativeMap = new TreeMap<>();

        for (int num : arr) {
            if (num >= 0)
                positiveMap.put(num, positiveMap.getOrDefault(num, 0) + 1);
            else
                negativeMap.put(-num, negativeMap.getOrDefault(-num, 0) + 1);
        }

        if (positiveMap.containsKey(0) && positiveMap.get(0) % 2 == 1) return false;

        while (positiveMap.size() > 0) {
            int num = positiveMap.firstKey();
            if (!positiveMap.containsKey(num * 2)) return false;

            positiveMap.put(num, positiveMap.get(num) - 1);
            positiveMap.put(num * 2, positiveMap.get(num * 2) - 1);
            if (positiveMap.get(num) == 0) positiveMap.remove(num);
            if (positiveMap.get(num * 2) == 0) positiveMap.remove(num * 2);
        }

        while (negativeMap.size() > 0) {
            int num = negativeMap.firstKey();
            if (!negativeMap.containsKey(num * 2)) return false;

            negativeMap.put(num, negativeMap.get(num) - 1);
            negativeMap.put(num * 2, negativeMap.get(num * 2) - 1);
            if (negativeMap.get(num) == 0) negativeMap.remove(num);
            if (negativeMap.get(num * 2) == 0) negativeMap.remove(num * 2);
        }

        return true;
    }

    public boolean canReorderDoubled2(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) continue;
            if (key < 0 && key % 2 == -1) return false;
            int tmp = key > 0 ? key * 2 : key / 2;
            if (tmp == 0) {
                if (map.get(tmp) % 2 == 1) return false;
            } else {
                if (!map.containsKey(tmp)) return false;
                int value = map.get(tmp);
                if (value < map.get(key)) return false;
                else map.put(tmp, value - map.get(key));
            }
        }
        return true;
    }
}
