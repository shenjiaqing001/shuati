package WeeklyContest219;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/16
 */
public class lc1689 {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            max = Math.max(max, c - '0');
        }
        return max;
    }
}
