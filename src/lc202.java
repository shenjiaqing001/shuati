import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc202 {
    public boolean isHappy(int n) {
        while (true) {
            int sum = 0;
            while (n != 0) {
                int last = n % 10;
                sum += last * last;
                n /= 10;
            }

            if (sum >= 1 && sum <= 9) {
                if (sum == 1 || sum == 7) return true;
                else return false;
            }
            n = sum;
        }
    }
}
