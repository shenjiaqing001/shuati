/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc727 {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        String res = "";
        int min = Integer.MAX_VALUE;
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length) {
            if (s[sIndex] == t[tIndex]) {
                tIndex++;
                if (tIndex == t.length) {
                    int now = sIndex;
                    tIndex--;
                    while (tIndex >= 0) {
                        if (s[sIndex] == t[tIndex]) {
                            tIndex--;
                        }
                        sIndex--;
                    }
                    sIndex++;
                    tIndex++;

                    if (min > now - sIndex + 1) {
                        res = S.substring(sIndex, now + 1);
                        min = res.length();
                    }
                }
            }
            sIndex++;
        }
        return res;
    }


    public String minWindow2(String S, String T) {
        S = '#' + S;
        int n = S.length();
        int[][] next = new int[n + 1][26];
        for (int i = 0; i < 26; ++i)
            next[n][i] = -1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j)
                next[i][j] = next[i + 1][j];
            if (i > 0)
                next[i][S.charAt(i) - 'a'] = i;
        }

        String res = "";
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        for (int i = 1; i < S.length(); ++i) {
            if (s[i] == t[0]) {
                int index = i;
                boolean flag = true;
                for (char tmp : t) {
                    index = next[index][tmp - 'a'];
                    if (index == -1) {
                        flag = false;
                        break;
                    } else {
                        index++;
                    }
                }
                if (flag) {
                    int len = index - i;
                    if (res.equals("") || len < res.length()) {
                        res = S.substring(i, index);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc727 t = new lc727();
        System.out.println(t.minWindow2("ffffessa", "fffessa"));
    }
}
