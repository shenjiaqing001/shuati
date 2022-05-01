package WeeklyContest290;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/23/22
 */
public class lc2 {
    public int countLatticePoints(int[][] circles) {
        Set<Integer> set = new HashSet<>();
        for (int[] c : circles) {
            for (int i = c[0] - c[2]; i <= c[0] + c[2]; ++i) {
                for (int j = c[1] - c[2]; j <= c[1] + c[2]; ++j) {
                    int dis = (i - c[0]) * (i - c[0]) + (j - c[1]) * (j - c[1]);
                    if (dis <= c[2] * c[2]) set.add(i * 10000 + j);
                }
            }
        }
        return set.size();
    }
}
