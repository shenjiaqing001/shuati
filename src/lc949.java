/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc949 {
    public String largestTimeFromDigits(int[] A) {
        int max = 0;
        String str = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (i == j) continue;
                for (int k = 0; k < 4; ++k) {
                    if (k == i || k == j) continue;
                    for (int m = 0; m < 4; ++m) {
                        if (m == k || m == i || m == j) continue;
                        int hour = 10 * A[i] + A[j];
                        int minute = 10 * A[k] + A[m];

                        int now = helper(hour, minute);
                        if (now >= max) {
                            max = now;
                            str = A[i] + "" + A[j] + ":" + A[k] + "" + A[m];
                        }
                    }
                }
            }
        }
        return str;
    }

    public int helper(int hour, int minute) {
        if (hour >= 24 || minute >= 60) return -1;
        return hour * 60 + minute;
    }
}
