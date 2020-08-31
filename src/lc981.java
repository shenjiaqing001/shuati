import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc981 {

    class TimeMap {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
            if (entry == null) return "";
            else return entry.getValue();
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


}
