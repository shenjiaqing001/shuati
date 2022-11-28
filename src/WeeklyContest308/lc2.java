package WeeklyContest308;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/22
 */
public class lc2 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
