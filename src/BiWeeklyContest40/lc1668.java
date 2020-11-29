package BiWeeklyContest40;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/29
 */
public class lc1668 {
    public int maxRepeating(String sequence, String word) {
        String repeat = word;
        int ans = 1;
        while (sequence.indexOf(repeat) >= 0) {
            ans++;
            repeat = repeat + word;
        }
        return ans - 1;
    }
}
