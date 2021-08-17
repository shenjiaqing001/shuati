import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/21
 */
public class lc731 {
    class MyCalendarTwo {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
                if (count > 2) {
                    map.put(start, map.getOrDefault(start, 0) - 1);
                    if (map.get(start) == 0) map.remove(start);

                    map.put(end, map.getOrDefault(end, 0) + 1);
                    if (map.get(end) == 0) map.remove(end);
                    return false;
                }
            }
            return true;
        }
    }
}
