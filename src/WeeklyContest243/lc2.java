package WeeklyContest243;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/29
 */
public class lc2 {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder(n);
        if (sb.charAt(0) != '-') {
            for (int i = 0; i < sb.length(); ++i) {
                if (sb.charAt(i) - '0' > x) {
                    sb.insert(i, x);
                    break;
                }
            }
        } else {
            for (int i = 0; i < sb.length(); ++i) {
                if (sb.charAt(i) - '0' >= x) {
                    sb.insert(i, x);
                    break;
                }
            }
        }
        if (sb.length() == n.length()) {
            sb.append(x);
        }
        return sb.toString();
    }
}
