/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/21
 */
public class lc214 {
    public String shortestPalindrome(String s) {
        if (s.equals("")) return s;
        char[] c = s.toCharArray();
        long base = 26;

        long pow_base = 1;
        int max = 0;
        long left = 0;
        long right = 0;
        for (int i = 0; i < c.length; ++i) {
            left = left * base + c[i] - 'a';
            right = right + pow_base * (c[i] - 'a');
            pow_base *= base;
//            System.out.println(left + " " + right);
            if (left == right) max = i;
        }
        StringBuilder sb = new StringBuilder(s.substring(max + 1));
        sb = sb.reverse();
        return sb.toString() + s;
    }


    public String shortestPalindrome2(String s) {
        if (s == null || s.equals("")) return "";
        char[] str = s.toCharArray();
        char[] c = new char[s.length() * 2 + 1];

        for (int i = 0; i < c.length; ++i) {
            c[i] = i % 2 == 0 ? '#' : str[i / 2];
        }

        int[] radius = new int[c.length];
        int center = -1;
        int maxRight = -1;
        for (int i = 0; i < c.length; ++i) {
            int r = i > maxRight ? 1 : Math.min(radius[center * 2 - i], maxRight - i + 1);
            while (i + r < c.length && i - r >= 0 && c[i - r] == c[i + r]) {
                r++;
            }
            radius[i] = r - 1;
            if (i + radius[i] > maxRight) {
                maxRight = i + radius[i];
                center = i;
            }
        }
        int max = 0;
        for (int i = 0; i < radius.length; ++i) {
            if (i - radius[i] == 0) {
                max = Math.max(max, (i + radius[i]) / 2);
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(max)).reverse();
        return sb + s;
    }
}
