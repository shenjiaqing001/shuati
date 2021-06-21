package WeeklyContest246;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/20
 */
public class lc1903 {
    public String largestOddNumber(String num) {
        int i;
        for (i = num.length() - 1; i >= 0; --i) {
            if ((num.charAt(i) - '0') % 2 == 1) break;
        }
        if (i <= 0) return "";
        return num.substring(0, i + 1);
    }
}
