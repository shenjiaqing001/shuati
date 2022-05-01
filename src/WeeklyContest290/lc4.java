package WeeklyContest290;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/23/22
 */
public class lc4 {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] f : flowers) {
            map.put(f[0], map.getOrDefault(f[0], 0) + 1);
            map.put(f[1] + 1, map.getOrDefault(f[1] + 1, 0) - 1);
        }
        int n = persons.length;
        int[][] np = new int[n][2];
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            np[i][0] = persons[i];
            np[i][1] = i;
        }
        Arrays.sort(np, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        int sum = 0;
        for (int key : map.keySet()) {
            while (index < n && np[index][0] < key) {
                res[np[index][1]] = sum;
                index++;
            }
            sum += map.get(key);
        }
        return res;
    }
}
