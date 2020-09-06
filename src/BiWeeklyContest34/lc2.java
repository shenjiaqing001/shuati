package BiWeeklyContest34;

import javax.swing.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc2 {
    public int numWays(String s) {
        char[] c = s.toCharArray();
        int n1 = 0;
        long n0 = 0;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == '0') n0++;
            else n1++;
        }
        if (n1 % 3 != 0) return 0;
        if (n1 == 0) {
            long a = (n0 - 1) * (n0 - 2) / 2;
            a %= (1000000000 + 7);
            return (int) a;
        }
        n1 /= 3;
        int count = 0;
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int index4 = -1;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == '1') {
                count++;
                if (index1 != -1 && index3 == -1) {
                    index3 = i;
                }
                if (index2 != -1 && index4 == -1) {
                    index4 = i;
                }
            }
            if (count == n1) {
                if (index1 == -1)
                    index1 = i;
            }
            if (count == n1 * 2) {
                if (index2 == -1)
                    index2 = i;
            }
        }
        long res = (long) (index3 - index1) * (long) (index4 - index2) % (1000000000 + 7);

        return (int) res;
    }
}
