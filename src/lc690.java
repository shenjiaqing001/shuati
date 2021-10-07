import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/6
 */
public class lc690 {
    public int dfs(Map<Integer, Employee> map, int root) {
        int sum = 0;
        if (!map.containsKey(root)) return 0;
        Employee e = map.get(root);
        if (e.subordinates != null && e.subordinates.size() > 0) {
            for (Integer child : e.subordinates) {
                sum += dfs(map, child);
            }
        }
        return sum + e.importance;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(map, id);
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
