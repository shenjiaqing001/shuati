/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/11
 */
public class lc1055 {
    public int shortestWay(String source, String target) {
        source = '#' + source;
        int n = source.length();
        // #abd n = 4;
        int[][] next = new int[n + 1][26];
        for (int i = 0; i < 26; ++i) {
            next[n][i] = -1;
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j)
                next[i][j] = next[i + 1][j];
            if (i != 0)
                next[i][source.charAt(i) - 'a'] = i;
        }

        int res = 1;
        int pos = 0;
        for (char c : target.toCharArray()) {
            if (next[pos][c - 'a'] == -1) {
                pos = 0;
                res++;
                if (next[pos][c - 'a'] == -1) return -1;
                else {
                    pos = next[pos][c - 'a'] + 1;
                }
            } else {
                pos = next[pos][c - 'a'] + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        lc1055 test = new lc1055();
        System.out.println(test.shortestWay("abc", "abc"));
    }
}
