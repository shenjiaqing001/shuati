import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/1
 */
public class lc218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for (int i = 0; i < buildings.length; ++i) {
            height.add(new int[]{buildings[i][0], buildings[i][2]});
            height.add(new int[]{buildings[i][1], -buildings[i][2]});
        }
        height.sort((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int last = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < height.size(); ++i) {
            if (height.get(i)[1] > 0) {
                pq.add(height.get(i)[1]);
            } else {
                pq.remove(-height.get(i)[1]);
            }
            int now = pq.peek();
            if (now != last) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(height.get(i)[0]);
                tmp.add(now);
                res.add(tmp);
                last = now;
            }
        }
        return res;
    }
}
