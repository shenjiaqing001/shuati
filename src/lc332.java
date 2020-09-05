import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new LinkedList<>();

        for (List<String> list : tickets) {
            map.putIfAbsent(list.get(0), new PriorityQueue<>());
            map.get(list.get(0)).add(list.get(1));
        }
        dfs(map, res, "JFK");
        return res;
    }

    public void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String departude) {
        PriorityQueue<String> arrivals = map.get(departude);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(map, res, arrivals.poll());
        res.add(0, departude);
    }
}
