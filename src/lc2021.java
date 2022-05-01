import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/28/22
 */
public class lc2021 {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] light : lights) {
            int center = light[0];
            int range = light[1];
            map.put(center - range, map.getOrDefault(center - range, 0) + 1);
            map.put(center + range + 1, map.getOrDefault(center + range + 1, 0) - 1);
        }
        int max = 0;
        int sum = 0;
        int index = 0;
        // System.out.println(map);
        for (int key : map.keySet()) {
            sum += map.get(key);
            if (sum > max) {
                sum = max;
                index = key;
            }
        }
        return index;
    }

}
