package WeeklyContest281;

import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/19/22
 */
public class lc3 {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (char c : s.toCharArray()) {
            treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
        }

        while (true) {
            if (treeMap.isEmpty()) break;
            Character c = treeMap.lastKey();
            if (treeMap.get(c) > repeatLimit) {
                for (int i = 0; i < repeatLimit; ++i) {
                    sb.append(c);
                }
                treeMap.put(c, treeMap.get(c) - repeatLimit);
                Character next = treeMap.floorKey((char) (c - 1));
                if (next == null) break;
                sb.append(next);
                treeMap.put(next, treeMap.get(next) - 1);
                if (treeMap.get(next) == 0) treeMap.remove(next);
            } else {
                for (int i = 0; i < treeMap.get(c); ++i) {
                    sb.append(c);
                }
                treeMap.remove(c);
            }
        }
        return sb.toString();
    }
}
