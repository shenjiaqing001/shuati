import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/28
 */
public class lc728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDiveding(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isSelfDiveding(int num) {
        int tmp = num;
        while (tmp > 0) {
            int now = tmp % 10;
            tmp /= 10;
            if (now == 0) return false;
            if (num % now != 0) return false;
        }
        return true;
    }
}
