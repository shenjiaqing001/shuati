package BiWeeklyContest69;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc1 {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] strs = title.split(" ");
        for (String s : strs) {
            if (s.length() <= 2) sb.append(s.toLowerCase());
            else {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
