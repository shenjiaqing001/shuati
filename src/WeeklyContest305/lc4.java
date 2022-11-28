package WeeklyContest305;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/22
 */
public class lc4 {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int max = 0;
        int[] longest = new int[26];
        for (char c : s.toCharArray()) {
            int tmpMax = 1;
            for (int tmp = c - 'a' - k; tmp <= c - 'a' + k; ++tmp) {
                if (tmp >= 0 && tmp < 26) {
                    tmpMax = Math.max(tmpMax, longest[tmp] + 1);
                }
            }
            longest[c-'a'] = tmpMax;
            max = Math.max(max,tmpMax);
        }
        return max;
    }
}
