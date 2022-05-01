package WeeklyContest291;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/30/22
 */
public class lc1 {
    public String removeDigit(String number, char digit) {
        int last = -1;
        char[] c = number.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == digit && i < c.length - 1 && c[i] < c[i + 1]) {
                return number.substring(0, i) + number.substring(i + 1);
            }
            if (c[i] == digit) {
                last = i;
            }
        }
        if (last == number.length() - 1) return number.substring(0, c.length - 1);
        if (last == 0) return number.substring(1);
        return number.substring(0, last) + number.substring(last + 1);
    }
}
