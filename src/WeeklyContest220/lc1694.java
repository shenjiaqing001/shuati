package WeeklyContest220;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/30
 */
public class lc1694 {
    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        int length = number.length();
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while (length > 4) {
            sb.append(number, pos, pos + 3);
            sb.append('-');
            pos += 3;
            length -= 3;
        }
        if (length == 2) sb.append(number, pos, pos + 2);
        else if (length == 3) sb.append(number, pos, pos + 3);
        else if (length == 4) {
            sb.append(number, pos, pos + 2);
            sb.append('-');
            sb.append(number, pos + 2, pos + 4);
        }
        return sb.toString();
    }
}
