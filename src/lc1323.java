/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/29/20
 */
public class lc1323 {
    public int maximum69Number(int num) {
        int i = 1;
        int ori = num;
        int now = 0;
        while (num > 0) {
            if (num % 10 == 6) {
                now = i;
            }
            num /= 10;
            i *= 10;
        }
        return ori + 3 * now;
    }
}
