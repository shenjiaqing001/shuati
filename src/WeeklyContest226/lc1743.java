package WeeklyContest226;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/31
 */
public class lc1743 {
    public class node {
        int left;
        int right;

        public node() {
            left = 100001;
            right = 100001;
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, node> map = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; ++i) {
            int a = adjacentPairs[i][0];
            int b = adjacentPairs[i][1];
            map.putIfAbsent(a, new node());
            map.putIfAbsent(b, new node());
            if (map.get(a).left == 100001) map.get(a).left = b;
            else map.get(a).right = b;
            if (map.get(b).left == 100001) map.get(b).left = a;
            else map.get(b).right = a;
        }

        int first = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key).right == 100001) {
                first = key;
                break;
            }
        }

        int[] res = new int[adjacentPairs.length + 1];
        res[0] = first;
        int next = map.get(first).left;
        res[1] = next;
        int last = first;
        for (int i = 2; i < res.length; ++i) {
            int tmp = 0;
            if (map.get(next).left == last) tmp = map.get(next).right;
            else tmp = map.get(next).left;
            res[i] = tmp;
            last = next;
            next = tmp;
        }
        return res;
    }
}
