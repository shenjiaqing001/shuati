package WeeklyContest282;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/26/22
 */
public class lc2 {
    public int minSteps(String s, String t) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count2[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            res += Math.abs(count1[i] - count2[i]);
        }
        return res;
    }
}
