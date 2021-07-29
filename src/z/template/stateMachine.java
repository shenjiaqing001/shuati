package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/14
 */
public class stateMachine {
    public void stateMachine(String S) {
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
    }
}
