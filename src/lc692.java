import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(
                (o1, o2) -> {
                    if (!Objects.equals(o1.getValue(), o2.getValue()))
                        return o1.getValue() - o2.getValue();
                    else
                        return o1.getKey().compareTo(o2.getKey());
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            q.add(entry);
            if (q.size() > k)
                q.poll();
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            res.add(q.poll().getKey());
        }
        return res;
    }
}
