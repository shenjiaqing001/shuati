package WeeklyContest284;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/12/22
 */
public class lc2 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int res = 0;
        int[][] map = new int[n][n];
        Map<Integer, Integer> aMap = new HashMap<>();
        int index = 1;
        for (int[] artifact : artifacts) {
            int size = 0;
            for (int i = artifact[0]; i <= artifact[2]; ++i) {
                for (int j = artifact[1]; j <= artifact[3]; ++j) {
                    map[i][j] = index;
                    size++;
                }
            }
            aMap.put(index, size);
            index++;
        }
        for (int[] d : dig) {
            int num = map[d[0]][d[1]];
            if (num != 0) {
                aMap.put(num, aMap.get(num) - 1);
                if (aMap.get(num) == 0) res++;
            }
        }

        return res;
    }
}
