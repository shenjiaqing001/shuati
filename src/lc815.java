import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/27
 */
public class lc815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        // n = how many routes
        int n = routes.length;
        for (int i = 0; i < n; ++i) {
            for (int num : routes[i]) {
                map.putIfAbsent(num, new ArrayList<>());
                map.get(num).add(i);
            }
        }

        Set<Integer> setSteps = new HashSet<>();
        Set<Integer> setRoutes = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        if (!map.containsKey(source)) return -1;
        for (int num : map.get(source)) {
            queue.add(num);
            setRoutes.add(num);
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; ++s) {
                int now = queue.poll();
                for (int num : routes[now]) {
                    if (num == target) return step;
                    if (setSteps.contains(num)) continue;
                    setSteps.add(num);
                    if (map.containsKey(num)) {
                        for (int route : map.get(num)) {
                            if (!setRoutes.contains(route)) {
                                setRoutes.add(route);
                                queue.add(route);

                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
