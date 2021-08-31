package BiWeeklyContest58;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1960 {
    public static void main(String[] args) {
        lc1960 test = new lc1960();
        test.manacher("ababbb");
    }

    public long maxProduct(String s) {
        int n = s.length();
        if (n == 2) return 1;
        int[] radius = manacher(s);
        long[] left = new long[n];

        int max = 1;
        left[0] = max;
        for (int i = 1; i <= n - 1; i++) {
            if (radius[(i - max - 1 + i) / 2] > max) max += 2;
            left[i] = max;
        }
        long[] right = new long[n];
        right[n - 1] = max = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (radius[(i + max + 1 + i) / 2] > max) max += 2;
            right[i] = max;
        }

        long res = 1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, left[i - 1] * right[i]);
        }
        return res;
    }

    public int[] manacher(String s) {
        char[] c = s.toCharArray();
        int[] radius = new int[c.length];
        int center = -1;
        int maxRight = -1;
        for (int i = 0; i < c.length; ++i) {
            int r = i <= maxRight ? Math.min(radius[center * 2 - i], maxRight - i) : 0;
            while (i + r < c.length && i - r >= 0 && c[i - r] == c[i + r]) {
                r++;
            }
            radius[i] = r - 1;
            if (i + radius[i] > maxRight) {
                maxRight = i + radius[i];
                center = i;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            radius[i] = 2 * radius[i] + 1;
        }

        return radius;
    }
}
