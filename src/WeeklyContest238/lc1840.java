package WeeklyContest238;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/27
 */
public class lc1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        int[][] r = new int[restrictions.length + 2][];
        for (int i = 0; i < restrictions.length; i++) {
            r[i] = restrictions[i];
        }
        r[r.length - 2] = new int[]{1, 0};
        r[r.length - 1] = new int[]{n, 1_000_000_000};
        restrictions = r;

        Arrays.sort(restrictions, (o1, o2) -> o1[0] - o2[0]);
        int height = 0;
        int index = 1;
        for (int i = 0; i < restrictions.length; ++i) {
            restrictions[i][1] =
                    Math.min(restrictions[i][1], height + (restrictions[i][0] - index));
            index = restrictions[i][0];
            height = restrictions[i][1];
        }
        for (int i = restrictions.length - 2; i >= 0; --i) {
            restrictions[i][1] = Math.min(restrictions[i][1],
                    restrictions[i + 1][1] + (restrictions[i + 1][0] - restrictions[i][0]));
        }

        int res = 0;

        for (int i = 1; i < restrictions.length; i++) {
            int d = restrictions[i][0] - restrictions[i - 1][0];
            int max = Math.max(restrictions[i][1], restrictions[i - 1][1]);
            res = Math.max(res, max);
            int min = Math.min(restrictions[i][1], restrictions[i - 1][1]);
            d = d - (max - min);
            res = Math.max(res, max + d / 2);
        }
        return res;
    }
}
