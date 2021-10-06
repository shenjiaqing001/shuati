package WeeklyContest251;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc1946 {
    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder(num);
        boolean flag = false;
        for (int i = 0; i < sb.length(); ++i) {
            if (flag) {
                int tmp = sb.charAt(i) - '0';
                if (tmp <= change[tmp]) {
                    sb.setCharAt(i, (char) (change[tmp] + '0'));
                } else break;
            } else {
                int tmp = sb.charAt(i) - '0';
                if (tmp < change[tmp]) {
                    flag = true;
                    sb.setCharAt(i, (char) (change[tmp] + '0'));
                }
            }
        }
        return sb.toString();
    }
}
