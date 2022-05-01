package WeeklyContest279;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/5/22
 */
public class lc4 {

    public int minimumTime(String S) {
        char[] c = S.toCharArray();
        int n = c.length;

        int[] dpLeftToRight = new int[n + 2];
        int[] dpRightToLeft = new int[n + 2];

        for (int i = 1; i <= n; ++i) {
            if (c[i - 1] == '0') {
                dpLeftToRight[i] = Math.min(i - 1, dpLeftToRight[i - 1]);
            } else {
                dpLeftToRight[i] = Math.min(i, dpLeftToRight[i - 1] + 2);
            }
        }

        for (int i = n; i >= 1; --i) {
            if (c[i - 1] == '0') {
                dpRightToLeft[i] = Math.min(n - i, dpRightToLeft[i + 1]);
            } else {
                dpRightToLeft[i] = Math.min(n + 1 - i, dpRightToLeft[i + 1] + 2);
            }
        }

        int min = n;
        for (int i = 1; i <= n; ++i) {
            if (c[i - 1] == '0')
                min = Math.min(min, dpLeftToRight[i] + dpRightToLeft[i]);
        }

        return min;
    }

    public static int solution(String S) {
        char[] c = S.toCharArray();
        int n = c.length;

        // 0   1----n   n+1
        int[] dpLeftToRight = new int[n + 2];
        int[] dpRightToLeft = new int[n + 2];

        for (int i = 1; i <= n; ++i) {
            if (c[i - 1] == 'a') {
                dpLeftToRight[i] = Math.min(i - 1, dpLeftToRight[i - 1]);
            } else {
                dpLeftToRight[i] = Math.min(i, dpLeftToRight[i - 1] + 2);
            }
        }

        for (int i = n; i >= 1; --i) {
            if (c[i - 1] == 'a') {
                dpRightToLeft[i] = Math.min(n - i, dpRightToLeft[i + 1]);
            } else {
                dpRightToLeft[i] = Math.min(n + 1 - i, dpRightToLeft[i + 1] + 2);
            }
        }

        int min = n;
        for (int i = 1; i <= n; ++i) {
            if (c[i - 1] == 'a')
                min = Math.min(min, dpLeftToRight[i] + dpRightToLeft[i]);
        }

        return min;
    }
}
