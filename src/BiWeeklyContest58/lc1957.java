package BiWeeklyContest58;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1957 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char last = ',';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == last) {
                if (count < 2) {
                    sb.append(c);
                    count++;
                }
            } else {
                last = c;
                count = 1;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
