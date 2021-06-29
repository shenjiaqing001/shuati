

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/28
 */
public class lc390 {
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        boolean flag = true;
        int remain = 1;
        int step = 1;
        while (n > 1) {
            if (flag || n % 2 == 1) {
                remain += step;
            }
            step *= 2;
            flag = !flag;
            n /= 2;
        }
        return remain;
    }
}
