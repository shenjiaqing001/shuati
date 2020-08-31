/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; ++i) {
            if (compare(words[i - 1], words[i], map) > 0)
                return false;
        }
        return true;
    }

    int compare(String s1, String s2, int[] map) {
        int n = s1.length(), m = s2.length();
        for (int i = 0, j = 0; i < n && j < m; i++, j++) {
            int pos1 = map[s1.charAt(i) - 'a'];
            int pos2 = map[s2.charAt(j) - 'a'];
            if (pos1 != pos2)
                return pos1 - pos2;
        }
        return n - m;
    }

}
