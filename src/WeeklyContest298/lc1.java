package WeeklyContest298;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/18/22
 */
public class lc1 {
    public String greatestLetter(String s) {
        int[] small = new int[26];
        int[] big = new int[26];
        for (char c : s.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                small[c - 'a']++;
            } else {
                big[c - 'a']++;
            }
        }
        int max = -1;
        for (int i = 0; i < 26; ++i) {
            if (small[i] > 0 && big[i] > 0) max = Math.max(max, i);
        }
        return max == -1 ? "" : String.valueOf((char) (max + 'a'));
    }
}
