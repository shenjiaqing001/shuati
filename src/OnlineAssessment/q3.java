package OnlineAssessment;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/29
 */
public class q3 {

    public int[] metroRouteDesignI(int[][] lines, int start, int end) {
        // now prev
        Map<Integer, Integer> route = new HashMap<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < lines.length; ++i) {
            for (int j = 0; j < lines[i].length; ++j) {
                map.putIfAbsent(lines[i][j], new ArrayList<>());
                map.get(lines[i][j]).add(new int[]{i, j});
            }
        }
        // to Id, from ID, turns, linesIndex
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        q.add(new int[]{start, -1, -1, -1});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (route.containsKey(now[0])) continue;
            route.put(now[0], now[1]);
            if (now[0] == end) break;

            for (int[] next : map.get(now[0])) {
                int n1p = next[1] + 1;
                int n1m = next[1] - 1;
                if (n1p < lines[next[0]].length) {
                    if (route.containsKey(lines[next[0]][n1p])) continue;
                    if (now[3] == next[0]) {
                        q.add(new int[]{lines[next[0]][n1p], now[0], now[2], next[0]});
                    } else {
                        q.add(new int[]{lines[next[0]][n1p], now[0], now[2] + 1, next[0]});
                    }
                }
                if (n1m >= 0) {
                    if (route.containsKey(lines[next[0]][n1m])) continue;
                    if (now[3] == next[0]) {
                        q.add(new int[]{lines[next[0]][n1m], now[0], now[2], next[0]});
                    } else {
                        q.add(new int[]{lines[next[0]][n1m], now[0], now[2] + 1, next[0]});
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int tmp = end;
        System.out.println(route);
        while (tmp != -1) {
            list.add(tmp);
            tmp = route.get(tmp);
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i = res.length - 1; i >= 0; --i) {
            res[index++] = list.get(i);
        }
        return res;
    }
}
