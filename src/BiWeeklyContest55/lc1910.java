package BiWeeklyContest55;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/26
 */
public class lc1910 {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int n = part.length();
        while (sb.indexOf(part) >= 0) {
            int index = sb.indexOf(part);
            sb.delete(index, index + n);
        }
        return sb.toString();
    }
}
