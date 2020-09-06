import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;

        List<Integer> listA = new LinkedList<>();
        List<Integer> listB = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n * n; ++i) {
            if (A[i / n][i % n] == 1)
                listA.add(i / n * 100 + i % n);
        }
        for (int i = 0; i < n * n; ++i) {
            if (B[i / n][i % n] == 1)
                listB.add(i / n * 100 + i % n);
        }

        for (int i : listA)
            for (int j : listB)
                map.put(i - j, map.getOrDefault(i - j, 0) + 1);

        int max = 0;
        for (Integer value : map.values())
            max = Math.max(max, value);
        return max;
    }
}
