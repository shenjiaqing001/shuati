/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/13/22
 */
public class lc8 {
    public int myAtoi(String s) {
        long positive = 1;
        boolean startFlag = false;
        long number = 0;
        for (char c : s.toCharArray()) {
            if (startFlag) {
                if ('0' <= c && c <= '9') {
                    number = 10 * number + (c - '0');
                    if (positive == 1 && number > Integer.MAX_VALUE) {
                        number = Integer.MAX_VALUE;
                        break;
                    }
                    if (positive == -1 && number > Integer.MAX_VALUE) {
                        number = (long) Integer.MAX_VALUE + 1l;
                    }
                } else {
                    break;
                }
            } else {
                if (c == '+' || c == '-') {
                    if (c == '-') positive = -1;
                    startFlag = true;
                } else if (c <= '9' && c >= '0') {
                    number = (c - '0');
                    startFlag = true;
                } else if (c != ' ') break;
            }
        }
        return (int) (positive * number);
    }
}
