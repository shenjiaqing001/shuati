import java.util.*;

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

    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int n = buildings.length;
        int[][] heights = new int[n * 2][];
        for (int i = 0; i < n; ++i) {
            heights[2 * i] = new int[]{buildings[i][0], buildings[i][2]};
            heights[2 * i + 1] = new int[]{buildings[i][1], -buildings[i][2]};
        }
        Arrays.sort(heights, (o1, o2) -> (
                o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0])));

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 0);
        int last = 0;
        for (int[] height : heights) {
            if (height[1] > 0) {
                map.put(height[1], map.getOrDefault(height[1], 0) + 1);
            } else {
                map.put(-height[1], map.get(-height[1]) - 1);
                if (map.get(-height[1]) == 0) map.remove(-height[1]);
            }
            int now = map.firstKey();
            if (last != now) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(height[0]);
                tmp.add(now);
                res.add(tmp);
                last = now;
            }
        }
        return res;
    }


}
