package OnlineAssessment.ebay;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class q2 {
    String equal(String str) {
        StringBuilder sb = new StringBuilder();
        int countW = 0;
        int countD = 0;
        int countL = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'W') countW++;
            if (c[i] == 'D') countD++;
            if (c[i] == 'L') countL++;
        }

        while (countW > 0 || countD > 0 || countL > 0) {
            if (countW > 0) {
                sb.append('W');
                countW--;
            }
            if (countD > 0) {
                sb.append('D');
                countD--;
            }
            if (countL > 0) {
                sb.append('L');
                countL--;
            }
        }
        return sb.toString();
    }
}
