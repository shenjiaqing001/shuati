package WeeklyContest238;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/25
 */
public class lc1839 {
    public int longestBeautifulSubstring(String word) {
        int sub = 1;
        int max = 1;
        int level = 1;
        char[] c = (word + "a").toCharArray();
        for (int i = 1; i < c.length; ++i) {
            if (c[i] < c[i - 1]) {
                if (c[i - 1] == 'u' && level == 5) {

                    max = Math.max(max, sub);
                }
                sub = 1;
                level = 1;
            } else {
                if (c[i] > c[i - 1]) level++;
                sub++;
            }
        }
        return max == 1 ? 0 : max;
    }
}
