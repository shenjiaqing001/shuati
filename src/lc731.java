import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/21
 */
public class lc731 {
    class MyCalendarTwo {
        TreeMap<Integer, Integer> once = new TreeMap();
        TreeMap<Integer, Integer> twice = new TreeMap();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            if (checkValid(once, start, end)) return true;
            if (checkValid(twice, start, end)) return true;
            return false;
        }

        public boolean checkValid(TreeMap<Integer, Integer> map, int start, int end) {
            Map.Entry<Integer, Integer> startFloor = map.floorEntry(start);
            Map.Entry<Integer, Integer> startCeiling = map.ceilingEntry(start);
            if (startFloor != null && startFloor.getValue() > start) {
                // todo
                return false;
            }
            if (startCeiling != null && startCeiling.getKey() < end) {
                // todo
                return false;
            }
            map.put(start, end);
            return true;
        }
    }
}
