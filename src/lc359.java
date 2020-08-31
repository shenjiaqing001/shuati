import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/7/20
 */
public class lc359 {
    class Logger {
        Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                int old = map.get(message);
                if (timestamp - old >= 10) {
                    map.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
    }
}
