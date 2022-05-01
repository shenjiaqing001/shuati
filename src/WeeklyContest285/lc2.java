package WeeklyContest285;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/19/22
 */
public class lc2 {
    public int countCollisions(String directions) {
        char[] c = directions.toCharArray();
        int res = c.length;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'L') {
                res--;
            } else {
                break;
            }
        }
        for (int i = c.length - 1; i >= 0; --i) {
            if (c[i] == 'R') {
                res--;
            } else {
                break;
            }
        }
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'S') res--;
        }
        return res;
    }
}
