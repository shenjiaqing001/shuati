package BiWeeklyContest51;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1844 {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i += 2) {
            sb.setCharAt(i, (char) (sb.charAt(i - 1) + (sb.charAt(i) - '0')));
        }

        return sb.toString();
    }
}
