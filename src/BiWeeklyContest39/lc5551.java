package BiWeeklyContest39;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/14
 */
public class lc5551 {
    public int minimumDeletions(String s) {
        if (s.length() == 1) return 0;
        char[] c = s.toCharArray();
        int[] dpA = new int[c.length];
        int[] dpB = new int[c.length];

        int tmp = 0;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'a') dpA[i] = tmp;
            else {
                tmp++;
                if (i != 0)
                    dpA[i] = dpA[i - 1];
            }
        }

        tmp = 0;
        for (int i = c.length - 1; i >= 0; --i) {
            if (c[i] == 'b') dpB[i] = tmp;
            else {
                tmp++;
                if (i != c.length - 1)
                    dpB[i] = dpB[i + 1];
            }
        }
        if (dpA[c.length - 1] == 0 || dpB[0] == 0) return 0;

        int min = c.length;
        for (int i = 0; i < c.length; ++i) {
            min = Math.min(min, dpA[i] + dpB[i]);
        }
        return min;
    }
}
