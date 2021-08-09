package BiWeeklyContest57;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc1 {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int tmp = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] == 0) continue;
            if (tmp == 0) {
                tmp = count[i];
            } else {
                if (tmp != count[i]) return false;
            }
        }
        return true;
    }
}
