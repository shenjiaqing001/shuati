import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/17/20
 */
public class lc170 {

    class TwoSum {
        Map<Integer, Integer> m = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            m.put(number, m.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Integer i : m.keySet()) {
                if (m.containsKey(value - i)) {
                    if (i == value - i && m.get(i) == 1) continue;
                    return true;
                }
            }
            return false;
        }
    }
}
