package WeeklyContest205;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc5510 {
    int res = 0;
    Map<Integer, Set<Integer>> map1;
    Map<Integer, Set<Integer>> map2;
    Map<Integer, Set<Integer>> map3;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        map3 = new HashMap<>();
        map2 = new HashMap<>();
        map1 = new HashMap<>();

        for (int i = 0; i < edges.length; ++i) {
            if (edges[i][0] == 3) {
                Set<Integer> set1 = map3.getOrDefault(edges[i][1], new HashSet<>());
                Set<Integer> set2 = map3.getOrDefault(edges[i][2], new HashSet<>());
                set1.add(edges[i][2]);
                set2.add(edges[i][1]);
                map3.put(edges[i][1], set1);
                map3.put(edges[i][2], set2);
            }
            if (edges[i][0] == 2) {
                Set<Integer> set1 = map2.getOrDefault(edges[i][1], new HashSet<>());
                Set<Integer> set2 = map2.getOrDefault(edges[i][2], new HashSet<>());
                set1.add(edges[i][2]);
                set2.add(edges[i][1]);
                map2.put(edges[i][1], set1);
                map2.put(edges[i][2], set2);
            }
            if (edges[i][0] == 1) {
                Set<Integer> set1 = map1.getOrDefault(edges[i][1], new HashSet<>());
                Set<Integer> set2 = map1.getOrDefault(edges[i][2], new HashSet<>());
                set1.add(edges[i][2]);
                set2.add(edges[i][1]);
                map1.put(edges[i][1], set1);
                map1.put(edges[i][2], set2);
            }
        }
        boolean[] visited3 = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited3[i] == false)
                bfs(i, visited3);
        }
        System.out.println(res);

        boolean[] visited2 = new boolean[n + 1];
        bfsSingle2(1, visited2);

        for (int i = 1; i <= n; ++i) {
            if (visited2[i] == false) return -1;
        }
        System.out.println(res);

        boolean[] visited1 = new boolean[n + 1];
        bfsSingle1(1, visited1);

        for (int i = 1; i <= n; ++i) {
            if (visited1[i] == false) return -1;
        }
        System.out.println(res);
        return res;
    }


    public void bfs(int start, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.add(new int[]{start, start});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (!map3.containsKey(now[0])) continue;
            Set<Integer> tmp = new HashSet<>(map3.get(now[0]));
            for (Integer next : tmp) {
                if (next == now[1]) continue;
                if (visited[next] == true) {
                    map3.get(now[0]).remove(next);
                    map3.get(next).remove(now[0]);
                    res++;
                } else {
                    visited[next] = true;
                    q.add(new int[]{next, now[0]});
                }
            }
        }
    }

    public void bfsSingle1(int start, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.add(new int[]{start, start});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map3.containsKey(now[0])) {
                Set<Integer> tmpDouble = new HashSet<>(map3.get(now[0]));
                for (Integer next : tmpDouble) {
                    if (next == now[1]) continue;
                    visited[next] = true;
                    q.add(new int[]{next, now[0]});
                }
            }

            if (map1.containsKey(now[0])) {
                Set<Integer> tmpSingle = new HashSet<>(map1.get(now[0]));
                for (Integer next : tmpSingle) {
                    if (next == now[1]) continue;
                    if (visited[next] == true) {
                        System.out.println(now[0] + " " + next);
                        map1.get(now[0]).remove(next);
                        map1.get(next).remove(now[0]);
                        res++;
                    } else {
                        visited[next] = true;
                        q.add(new int[]{next, now[0]});
                    }
                }
            }
        }
    }

    public void bfsSingle2(int start, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.add(new int[]{start, start});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map3.containsKey(now[0])) {
                Set<Integer> tmpDouble = new HashSet<>(map3.get(now[0]));
                for (Integer next : tmpDouble) {
                    if (next == now[1]) continue;
                    visited[next] = true;
                    q.add(new int[]{next, now[0]});
                }
            }

            if (map2.containsKey(now[0])) {
                Set<Integer> tmpSingle = new HashSet<>(map2.get(now[0]));
                for (Integer next : tmpSingle) {
                    if (next == now[1]) continue;
                    if (visited[next] == true) {
                        System.out.println(now[0] + " " + next);
                        map2.get(now[0]).remove(next);
                        map2.get(next).remove(now[0]);
                        res++;
                    } else {
                        visited[next] = true;
                        q.add(new int[]{next, now[0]});
                    }
                }
            }
        }
    }

}
