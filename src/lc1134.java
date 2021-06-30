import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/30
 */
public class lc1134 {
    public boolean isArmstrong(int n) {
        int init = n;
        int count = 0;
        List<Integer> list = new LinkedList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
            count++;
        }
        long res = 0;
        for (int num : list) {
            res += Math.pow(num, count);
        }
        return res == init;
    }
}
