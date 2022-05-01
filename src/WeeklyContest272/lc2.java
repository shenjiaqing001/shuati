package WeeklyContest272;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/18/21
 */
public class lc2 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int index = 0;
        for (int i = 0; i < c.length; ++i) {
            if (index < spaces.length && i == spaces[index]) {
                sb.append(" ");
                index++;
            }
            sb.append(c[i]);
        }
        return sb.toString();
    }
}
