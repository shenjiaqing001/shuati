import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/30
 */
public class lc1396 {
    class UndergroundSystem {
        Map<Integer, Map.Entry<String, Integer>> map = new HashMap<>();
        Map<String, Map<String, Integer>> sum = new HashMap<>();
        Map<String, Map<String, Integer>> times = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            Map.Entry<String, Integer> p = new AbstractMap.SimpleEntry<>(stationName, t);
            sum.putIfAbsent(stationName, new HashMap<>());
            times.putIfAbsent(stationName, new HashMap<>());
            map.put(id, p);
        }

        public void checkOut(int id, String stationName, int t) {
            Map.Entry<String, Integer> p = map.get(id);
            sum.get(p.getKey()).putIfAbsent(stationName, 0);
            times.get(p.getKey()).putIfAbsent(stationName, 0);

            sum.get(p.getKey())
                    .put(stationName, sum.get(p.getKey()).get(stationName) + t - p.getValue());


            times.get(p.getKey()).put(stationName, times.get(p.getKey()).get(stationName) + 1);
            System.out.println(sum.get(p.getKey()).get(stationName));
        }

        public double getAverageTime(String startStation, String endStation) {
            int total_sum =
                    sum.getOrDefault(startStation, new HashMap<>()).getOrDefault(endStation, 0);
            int total_timtes =
                    times.getOrDefault(startStation, new HashMap<>()).getOrDefault(endStation, 0);
            System.out.println(total_sum + " " + total_timtes);
            if (total_timtes == 0) return 0;
            return (double) total_sum / (double) total_timtes;
        }
    }
}
