package WeeklyContest295;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/28/22
 */
public class lc1 {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int min = 100;
        int[] count2 = new int[26];
        for (char c : target.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (count2[i] != 0) {
                min = Math.min(min, count[i] / count2[i]);
            }
        }
        return min;
    }

}
