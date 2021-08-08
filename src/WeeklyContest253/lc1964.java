package WeeklyContest253;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = obstacles.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            if (map.floorKey(obstacles[i]) == null) {
                map.put(obstacles[i], 1);
                res[i] = 1;
            } else {
                int key = map.floorKey(obstacles[i]);
                res[i] = map.get(key) + 1;
                map.put(obstacles[i], res[i]);
            }
            while (map.ceilingKey(obstacles[i] + 1) != null) {
                int key = map.ceilingKey(obstacles[i] + 1);
                if (map.get(key) <= res[i]) map.remove(key);
                else break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc1964 test = new lc1964();
        System.out.println(
                Arrays.toString(
                        test.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2})));
    }

}
