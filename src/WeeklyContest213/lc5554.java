package WeeklyContest213;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/1
 */
public class lc5554 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) map.put(arr[i], i);

        for (int i = 0; i < pieces.length; ++i) {
            if (!map.containsKey(pieces[i][0])) return false;
            int start = map.get(pieces[i][0]);
            int end = start + pieces[i].length - 1;
            if (end >= arr.length) return false;
            for (int j = start; j <= end; ++j) {
                if (arr[j] != pieces[i][j - start]) return false;
            }
        }

        return true;
    }
}
