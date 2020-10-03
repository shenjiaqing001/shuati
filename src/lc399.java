import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/3
 */
public class lc399 {
    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);
            map.putIfAbsent(str1, new HashMap<>());
            map.putIfAbsent(str2, new HashMap<>());
            map.get(str1).put(str2, values[i]);
            map.get(str2).put(str1, 1 / values[i]);
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); ++i) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), map);
        }
        return res;
    }


    public double dfs(String start, String end, Set<String> visited,
                      Map<String, Map<String, Double>> map) {
        if (!map.containsKey(start))
            return -1.0;
        if (map.get(start).containsKey(end))
            return map.get(start).get(end);

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : map.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double productWeight = dfs(neighbour.getKey(), end, visited, map);
                if (productWeight != -1.0)
                    return neighbour.getValue() * productWeight;
            }
        }
        return -1.0;
    }

}
