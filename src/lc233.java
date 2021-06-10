/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/26
 */
public class lc233 {
    public int countDigitOne(int n) {
        int count = 0;
        int times = 1;
        int right = 0;
        while (n > 0) {
            if (n % 10 >= 2) {
                count += (n / 10 + 1) * times;
            } else if (n % 10 == 0) {
                count += (n / 10) * times;
            } else {
                count += (n / 10) * times;
                count += right + 1;
            }
            // System.out.println(n + " " + times + " " + right + " " + count);
            right = right + (n % 10) * times;
            times *= 10;
            n /= 10;
        }
        return count;
    }
    /*
    123456



    12345



     */
}
