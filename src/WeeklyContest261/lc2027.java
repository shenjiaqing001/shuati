package WeeklyContest261;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2027 {
    public int minimumMoves(String s) {
        char[] c = s.toCharArray();
        int index = 0;
        int res = 0;
        while (index < c.length) {
            if (c[index] == 'X') {
                index += 3;
                res++;
            } else {
                index++;
            }
        }
        return res;
    }
}
