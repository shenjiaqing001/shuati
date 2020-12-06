package WeeklyContest215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/15
 */
public class lc5601 {
    class OrderedStream {
        int ptr = 1;
        int total = 0;
        Map<Integer, String> map = new HashMap<>();

        public OrderedStream(int n) {
            total = n;
        }

        public List<String> insert(int id, String value) {
            List<String> res = new ArrayList<>();
            map.put(id, value);
            while (map.containsKey(ptr)) {
                res.add(map.get(ptr++));
            }
            return res;
        }
    }
}
