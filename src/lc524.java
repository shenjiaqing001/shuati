import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/13
 */
public class lc524 {
    public String findLongestWord(String s, List<String> d) {
        s = '#' + s;
        int n = s.length();
        int[][] next = new int[n + 1][26];
        for (int i = 0; i < 26; ++i)
            next[n][i] = -1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j)
                next[i][j] = next[i + 1][j];
            if (i > 0)
                next[i][s.charAt(i) - 'a'] = i;
        }

        Collections.sort(d, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o2.length() - o1.length();
        });

        for (String word : d) {
            int pos = 0;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (next[pos][c - 'a'] == -1) {
                    flag = false;
                    break;
                }
                pos = next[pos][c - 'a'] + 1;
            }
            if (flag) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        lc524 test = new lc524();
        test.findLongestWord("aaa", new ArrayList<>());
    }

}
