import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/20
 */
public class lc732 {
    class MyCalendarThree {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int max = 0;
            int sum = 0;
            for (int key : map.keySet()) {
                sum += map.get(key);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}
