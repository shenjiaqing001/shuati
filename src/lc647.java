/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc647 {

    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); ++i) {
            dfs(s, i, i);
            dfs(s, i, i + 1);
        }
        return count;
    }

    public void dfs(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            count++;
            left--;
            right++;
        }
    }

    public int countSubstrings2(String s) {
        if (s == null || s.equals("")) return 0;
        char[] str = s.toCharArray();
        char[] c = new char[s.length() * 2 + 1];

        for (int i = 0; i < c.length; ++i) {
            c[i] = i % 2 == 0 ? '#' : str[i / 2];
        }

        int[] radius = new int[c.length];
        int center = -1;
        int maxRight = -1;
        int res = 0;
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
            res += r / 2;
        }
        return res;
    }

}
