package WeeklyContest225;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/24
 */
public class lc1 {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder(time);
        if (sb.charAt(0) == '?') {
            if (sb.charAt(1) == '?') sb.setCharAt(0, '2');
            else {
                if (sb.charAt(1) >= '4') sb.setCharAt(0, '1');
                else sb.setCharAt(0, '2');
            }
        }
        if (sb.charAt(1) == '?') {
            if (sb.charAt(0) == '2') sb.setCharAt(1, '3');
            else sb.setCharAt(1, '9');
        }

        if (sb.charAt(3) == '?') sb.setCharAt(3, '5');
        if (sb.charAt(4) == '?') sb.setCharAt(4, '9');
        return sb.toString();
    }
}
