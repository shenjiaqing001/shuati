/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/29
 */
public class lc849 {
    public int maxDistToClosest(int[] seats) {
        int max = 1;
        int n = seats.length;
        if (seats[0] == 0) {
            for (int i = 1; i < n; ++i) {
                if (seats[i] == 1) {
                    max = Math.max(max, i - 0);
                    break;
                }
            }
        }
        if (seats[n - 1] == 0) {
            for (int i = n - 2; i >= 0; --i) {
                if (seats[i] == 1) {
                    max = Math.max(max, n - 1 - i);
                    break;
                }
            }
        }

        seats[0] = 1;
        seats[n - 1] = 1;
        int last = 0;
        for (int i = 1; i < n; ++i) {
            if (seats[i] == 1) {
                max = Math.max(max, (i - last) / 2);
                last = i;
            }
        }


        return max;
    }
}
