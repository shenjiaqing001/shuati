/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/8/22
 */
public class lc258 {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
