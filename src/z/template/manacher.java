package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/30
 */
public class manacher {


    public int manacher(String s) {
        if (s == null || s.equals("")) return 0;
        char[] str = s.toCharArray();
        char[] c = new char[s.length() * 2 + 1];

        for (int i = 0; i < c.length; ++i) {
            c[i] = i % 2 == 0 ? '#' : str[i / 2];
        }

        int[] radius = new int[c.length];
        int center = -1;
        int maxRight = -1;
        for (int i = 0; i < c.length; ++i) {
            int r = 0;
            if (i <= maxRight) {
                r = Math.min(radius[center * 2 - i], maxRight - i);
            }

            while (i + r < c.length && i - r >= 0 &&
                    c[i - r] == c[i + r]) {
                r++;
            }

            radius[i] = r - 1;
            if (i + radius[i] > maxRight) {
                maxRight = i + radius[i];
                center = i;
            }
        }
        return 0;
    }

}
