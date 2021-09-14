package WeeklyContest257;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        // attack, defense
        Arrays.sort(properties, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));
        int res = 0;
        int[] lastMax = null;
        int[] max = null;
        for (int[] property : properties) {
            if (max == null) {
                max = property;
                continue;
            }
            if (property[0] < max[0] && property[1] < max[1]) res++;
            else {
                if (property[0] == max[0]) continue;
                if (lastMax == null) {
                    lastMax = property;
                } else {
                    if (property[0] == lastMax[0]) {
                        if (property[0] < max[0] && property[1] < max[1]) res++;
                    } else {
                        max = lastMax;
                        lastMax = null;
                        if (property[0] < max[0] && property[1] < max[1]) res++;
                        else {
                            lastMax = property;
                        }
                    }
                }
            }
        }
        return res;
    }
}
