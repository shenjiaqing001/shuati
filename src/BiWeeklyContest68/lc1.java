package BiWeeklyContest68;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc1 {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            max = Math.max(max, s.split(" ").length);
        }
        return max;
    }
}
