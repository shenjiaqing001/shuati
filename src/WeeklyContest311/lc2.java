package WeeklyContest311;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/22
 */
public class lc2 {
    public int longestContinuousSubstring(String s) {
        int max = 1;
        int count = 0;
        char last = 'A';
        for (char c : s.toCharArray()) {
            if (c == last + 1) {
                count++;
            } else {
                count = 1;
            }
            last = c;
            max = Math.max(max, count);
        }
        return max;
    }
}
