package WeeklyContest271;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc1 {
    public int countPoints(String rings) {
        char[] c = rings.toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < c.length; i += 2) {
            char color = c[i];
            int pos = c[i + 1] - '0';
            if (color == 'R') {
                count[pos] |= 1;
            }
            if (color == 'G') {
                count[pos] |= 2;
            }
            if (color == 'B') {
                count[pos] |= 4;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; ++i) {
            if (count[i] == 7) {
                res++;
            }
        }
        return res;
    }
}
