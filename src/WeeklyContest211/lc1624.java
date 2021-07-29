package WeeklyContest211;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class lc1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] left = new int[26];
        for (int i = 0; i < 26; ++i) left[i] = -1;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (left[c[i] - 'a'] == -1) left[c[i] - 'a'] = i;
            else {
                max = Math.max(max, i - left[c[i] - 'a']-1);
            }
        }
        return max;
    }
}
