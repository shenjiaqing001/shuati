package WeeklyContest290;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/23/22
 */
public class lc3 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] lists = new List[101];
        for (int i = 0; i < lists.length; ++i) {
            lists[i] = new ArrayList<>();
        }
        for (int[] r : rectangles) {
            lists[r[1]].add(r[0]);
        }
        for (int i = 0; i < lists.length; ++i) {
            lists[i].sort(Comparator.comparingInt(o -> o));
        }
        int n = points.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int[] p = points[i];
            for (int j = p[1]; j <= 100; ++j) {
                if (lists[j].size() == 0) continue;
                int left = 0;
                int right = lists[j].size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (lists[j].get(mid) >= p[0]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                res[i] += lists[j].size() - left;
            }
        }
        return res;
    }
}
