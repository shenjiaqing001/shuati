package WeeklyContest287;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/2/22
 */
public class lc1 {
    // 1, 5, 15, or 60
    public int convertTime(String current, String correct) {
        String[] s1 = current.split(":");
        String[] s2 = correct.split(":");
        int t1 = Integer.valueOf(s1[0]) * 60 + Integer.valueOf(s1[1]);
        int t2 = Integer.valueOf(s2[0]) * 60 + Integer.valueOf(s2[1]);
        int res = 0;
        int remain = t2 - t1;
        res += remain / 60;
        remain %= 60;
        res += remain / 15;
        remain %= 15;
        res += remain / 5;
        remain %= 5;
        res += remain;
        return res;
    }


}
