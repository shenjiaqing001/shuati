import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/19
 */
public class lc56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));

        int[] now;
        List<int[]> result = new ArrayList<>();
        now = intervals[0];
        result.add(now);
        for (int i = 1; i < intervals.length; ++i) {
            if (now[1] >= intervals[i][0]) {
                now[1] = Math.max(intervals[i][1], now[1]);
            } else {
                now = intervals[i];
                result.add(now);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] interval : intervals) {
            treeMap.put(interval[0], treeMap.getOrDefault(interval[0], 0) + 1);
            treeMap.put(interval[1], treeMap.getOrDefault(interval[1], 0) - 1);
        }
        List<int[]> result = new ArrayList<>();
        Integer start = treeMap.firstKey();
        int sum = treeMap.get(start);
        while (start != null) {
            int last = start;
            while (sum != 0) {
                last = treeMap.ceilingKey(last + 1);
                sum += treeMap.get(last);
            }
            result.add(new int[]{start, last});
            start = treeMap.ceilingKey(last + 1);
            if(start != null)
                sum = treeMap.get(start);
        }
        return result.toArray(new int[result.size()][]);
    }

    

}
