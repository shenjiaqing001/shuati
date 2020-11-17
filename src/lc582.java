import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/17
 */
public class lc582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); ++i) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        dfs(map, res, kill);
        return res;
    }

    public void dfs(Map<Integer, List<Integer>> map, List<Integer> res, int id) {
        res.add(id);
        if (map.containsKey(id)) {
            for (Integer child : map.get(id)) {
                dfs(map, res, child);
            }
        }
    }
}
