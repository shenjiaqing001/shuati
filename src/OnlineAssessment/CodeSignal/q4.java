package OnlineAssessment.CodeSignal;

import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/19
 */
public class q4 {
    long[][][] field(long[][] chunks) {
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        int n = chunks.length;
        long[][][] res = new long[n][][];
        int idx = 0;
        for (long[] chunk : chunks) {
            chunk[1] += 1;
            Long first = treeMap.floorKey(chunk[1]);
            if (first == null || treeMap.get(first) < chunk[0]) {
                treeMap.put(chunk[0], chunk[1]);
            } else if (first <= chunk[0] && treeMap.get(first) >= chunk[1]) {
                // do nothing
            } else {
                long lo = chunk[0];
                long hi = chunk[1];
                while (first != null && treeMap.get(first) >= chunk[0]) {
                    hi = Math.max(treeMap.get(first), hi);
                    lo = Math.min(first, lo);
                    treeMap.remove(first);
                    first = treeMap.floorKey(lo);
                }
                treeMap.put(lo, hi);
            }

            int idx2 = 0;
            res[idx] = new long[treeMap.size()][2];
            for (Long key : treeMap.keySet()) {
                res[idx][idx2][0] = key;
                res[idx][idx2][1] = treeMap.get(key) - 1;
                idx2++;
            }
            idx++;
        }
        return res;
    }


}
