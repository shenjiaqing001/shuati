package WeeklyContest208;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/27
 */
public class lc5523 {
    public int minOperations(String[] logs) {
        int res = 0;
        for (int i = 0; i < logs.length; ++i) {
            if (logs[i].equals("./")) continue;
            if (logs[i].equals("../")) {
                res--;
                if (res <= 0) res = 0;
            } else {
                res++;
            }
        }
        return res;
    }
}
