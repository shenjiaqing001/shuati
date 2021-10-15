package WeeklyContest262;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc2034 {
    class StockPrice {

        // price  ,set<time>
        TreeMap<Integer, Set<Integer>> priceMap = new TreeMap<>();
        // time  price
        TreeMap<Integer, Integer> time = new TreeMap<>();

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if (time.containsKey(timestamp)) {
                int oldPrice = time.get(timestamp);
                priceMap.get(oldPrice).remove(timestamp);
                if (priceMap.get(oldPrice).size() == 0) {
                    priceMap.remove(oldPrice);
                }
            }
            priceMap.putIfAbsent(price, new HashSet<>());
            priceMap.get(price).add(timestamp);
            time.put(timestamp, price);
        }

        public int current() {
            Map.Entry<Integer, Integer> cur = time.lastEntry();
            return cur.getValue();
        }

        public int maximum() {
            return priceMap.lastKey();
        }

        public int minimum() {
            return priceMap.firstKey();
        }
    }

}
