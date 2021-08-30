/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/28
 */
public class lc5 {
    int lo = 0;
    int maxLen = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;

        char[] c = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            calMax(c, i, i);
            calMax(c, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void calMax(char[] c, int i, int j) {
        while (i >= 0 && j < c.length && c[i] == c[j]) {
            i--;
            j++;
        }

        if (maxLen < j - i - 1) {
            lo = i + 1;
            maxLen = j - i - 1;
        }
    }


    public String longestPalindrome2(String s) {
        String string = s;
        if (string == null || string == "") return "";
        if (string.length() == 1) return string;

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : string.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }

        char[] c = sb.toString().toCharArray();
        int[] radius = new int[c.length];
        int center = -1;
        int r = -1;
        String res = "";
        for (int i = 0; i < c.length; ++i) {
            radius[i] = r > i ? Math.min(radius[2 * center - r], r - i + 1) : 1;
            while (i + radius[i] < c.length && i - radius[i] > -1) {
                if (c[i - radius[i]] == c[i + radius[i]]) {
                    radius[i]++;
                } else break;
            }
            if (i + radius[i] > r) {
                r = i + radius[i] - 1;
                center = i;
            }

            if (radius[i] > res.length()) {
                res = string.substring((center - radius[i]) / 2, (center + radius[i]) / 2);
            }
        }
        return res;
    }
}
