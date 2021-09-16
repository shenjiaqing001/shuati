package BiWeeklyContest59;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1974 {
    public int minTimeToType(String word) {
        int res = 0;
        int last = 0;
        for (char c : word.toCharArray()) {
            res += Math.min(Math.abs(c - 'a' - last), 26 - Math.abs(c - 'a' - last));
            res += 1;
            last = c - 'a';
        }
        return res;
    }
}
