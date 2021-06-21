import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/11
 */
public class lc729 {
    class MyCalendar {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer floorKey = map.floorKey(start);
            if (floorKey != null && map.get(floorKey) > start) return false;
            Integer ceilingKey = map.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return false;
            map.put(start, end);
            return true;
        }
    }

}
