import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/7/20
 */
public class lc1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); ++i) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); ++j) {
                if (!map.containsKey(i + j))
                    map.put(i + j, new LinkedList<>());
                map.get(i + j).add(0, list.get(j));
                max = Math.max(i + j, max);
                n++;
            }
        }
        int[] res = new int[n];
        int now = 0;
        for (int i = 0; i <= max; ++i) {
            if (!map.containsKey(i)) continue;
            List<Integer> list = map.get(i);
            for (Integer tmp : list) res[now++] = tmp;
        }
        return res;
    }
}
