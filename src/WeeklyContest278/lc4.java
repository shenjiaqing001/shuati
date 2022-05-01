package WeeklyContest278;

import java.beans.JavaBean;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/29/22
 */
public class lc4 {

    public class UnionFind {
        Map<Integer, Integer> p = new HashMap<>();

        public UnionFind() {

        }

        public int get(int x) {
            if (!p.containsKey(x)) {
                p.put(x, x);
                return x;
            } else {
                if (x == p.get(x)) return x;
                int tmp = get(p.get(x));
                p.put(x, tmp);
                return tmp;
            }
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p.get(a) < p.get(b)) {
                p.put(b, a);
            } else {
                p.put(a, b);
            }
        }
    }

    int max = 0;
    Map<Integer, Set<Integer>> connect = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    Map<Integer, List<Integer>> changeOneMap = new HashMap<>();
    int count = 0;

    public int[] groupStrings(String[] words) {
        for (String word : words) {
            int hash = 0;
            for (char c : word.toCharArray()) {
                hash |= (1 << (c - 'a'));
            }
            countMap.put(hash, countMap.getOrDefault(hash, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            for (int i = 0; i < 26; ++i) {
                if ((key & (1 << i)) != 0) {
                    int child = key ^ (1 << i);
                    changeOneMap.putIfAbsent(child, new ArrayList<>());
                    changeOneMap.get(child).add(key);
                }
            }
        }

        for (int key : countMap.keySet()) {
            connect.put(key, new HashSet<>());
        }

        for (int key : connect.keySet()) {
            for (int i = 0; i < 26; ++i) {
                if ((key & (1 << i)) != 0) {
                    int child = key ^ (1 << i);
                    if (connect.containsKey(child)) {
                        connect.get(child).add(key);
                        connect.get(key).add(child);
                    }
                    if (changeOneMap.containsKey(child)) {
                        for (Integer val : changeOneMap.get(child)) {
                            connect.get(key).add(val);
                        }
                    }
                }
            }
        }
        // System.out.println(connect);

        for (int key : connect.keySet()) {
            connect.get(key).remove(key);
        }

        UnionFind uf = new UnionFind();
        for (int key : connect.keySet()) {
            for (int con : connect.get(key)) {
                if (uf.get(key) != uf.get(con)) {
                    uf.union(key, con);
                }
            }
        }
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int key : countMap.keySet()) {
            int p = uf.get(key);
            // System.out.println(key + " " + uf.get(key));
            tmp.put(p, tmp.getOrDefault(p, 0) + countMap.get(key));
        }

        for (int value : tmp.values()) {
            max = Math.max(max, value);
        }
        return new int[]{tmp.size(), max};
    }


    public static void main(String[] args) {
        lc4 test = new lc4();

        test.groupStrings(new String[]{"a", "b", "ab", "edf"});
    }
}
