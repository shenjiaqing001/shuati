import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/20
 */
public class lc1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new LinkedList<>();
        for (int i = 2; i <= 9; ++i) {
            for (int j = 0; j <= 9 - i; ++j) {
                int num = Integer.valueOf(s.substring(j, j + i));
                if (num > high) return res;
                if (num >= low) res.add(num);
            }
        }
        return res;
    }
}
