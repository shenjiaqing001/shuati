package OnlineAssessment.DataBrikes;

import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/19
 */
public class q4 {
    long[] field(long[][] chunks) {
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        int n = chunks.length;
        long[] res = new long[n];
        long sum = 0;
        int idx = 0;
        for (long[] chunk : chunks) {
            Long first = treeMap.floorKey(chunk[1]);
            if (first == null || treeMap.get(first) < chunk[0]) {
                sum += chunk[1] - chunk[0] + 1;
                treeMap.put(chunk[0], chunk[1]);
            } else if (first <= chunk[0] && treeMap.get(first) >= chunk[1]) {
                // do nothing
            } else {
                sum += chunk[1] - chunk[0] + 1;
                long lo = chunk[0];
                long hi = chunk[1];
                while (first != null && treeMap.get(first) >= chunk[0]) {
                    long interLo = Math.max(first, lo);
                    long interHi = Math.min(treeMap.get(first), hi);
                    sum -= interHi - interLo + 1;
                    hi = Math.max(treeMap.get(first), hi);
                    lo = Math.min(first, lo);
                    treeMap.remove(first);
                    first = treeMap.floorKey(lo);
                }
                treeMap.put(lo, hi);
            }
            res[idx++] = sum;
        }
        return res;
    }


}
