import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc1152 {
    public class Pair {
        int timestamp;
        String webside;

        public Pair(int timestamp, String webside) {
            this.timestamp = timestamp;
            this.webside = webside;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp,
                                           String[] website) {
        Map<String, LinkedList<Pair>> map = new HashMap<>();
        int num = username.length;
        for (int i = 0; i < num; ++i) {
            map.putIfAbsent(username[i], new LinkedList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> count = new HashMap<>();
        String res = "";

        for (String key : map.keySet()) {
            LinkedList<Pair> list = map.get(key);
            list.sort(Comparator.comparingInt(o -> o.timestamp));
            Set<String> set = new HashSet<>();
            for (int i = 0; i < list.size(); ++i) {
                for (int j = i + 1; j < list.size(); ++j) {
                    for (int k = j + 1; k < list.size(); ++k) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(list.get(i).webside).append(" ").append(list.get(j).webside).append(" ")
                                .append(list.get(k).webside);
                        String str = sb.toString();
                        if (!set.contains(str)) {
                            set.add(str);
                            count.put(str, count.getOrDefault(str, 0) + 1);
                        }
                        if (res == "" || count.get(res) < count.get(str) ||
                                (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            res = str;
                        }
                    }
                }
            }
        }
        return Arrays.asList(res.split(" "));
    }
}
