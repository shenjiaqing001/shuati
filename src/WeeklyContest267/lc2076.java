package WeeklyContest267;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class lc2076 {

    // 1 2 3 2 1 6
    public static void main(String[] args) {
        lc2076 test = new lc2076();
        System.out.println(
                test.friendRequests(5, new int[][]{{0, 1}, {1, 2}, {2, 3}},
                        new int[][]{{0, 4}, {1, 2}}));
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int numberOfRequests = requests.length;
        boolean[] res = new boolean[numberOfRequests];
        UnionFind uf = new UnionFind(n);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) map.put(i, new HashSet<>());
        for (int[] restriction : restrictions) {
            map.get(restriction[0]).add(restriction[1]);
            map.get(restriction[1]).add(restriction[0]);
        }
        int index = 0;
        for (int[] request : requests) {
            int p1 = uf.get(request[0]);
            int p2 = uf.get(request[1]);
            if (p1 == p2) {
                res[index] = true;
                index++;
                continue;
            }
            if (map.get(p1).contains(p2) || map.get(p2).contains(p1)) {
                index++;
            } else {
                res[index] = true;
                index++;
                uf.union(request[0], request[1]);
                int rp = uf.get(request[0]);
                if (rp == p1) {
                    for (int tt : map.get(p2))
                        map.get(p1).add(uf.get(tt));
                } else {
                    for (int tt : map.get(p1))
                        map.get(p2).add(uf.get(tt));
                }
            }
        }
        return res;
    }

    public class UnionFind {
        int[] p;

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; ++i) p[i] = i;
        }

        public int get(int x) {
            return p[x] == x ? x : (p[x] = get(p[x]));
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p[a] < p[b]) p[b] = p[a];
            else p[a] = p[b];
        }
    }
}
