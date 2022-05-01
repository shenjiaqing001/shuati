package WeeklyContest283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/5/22
 */
public class lc4 {

    public int gcd(int a, int b) {
        int tmp = 1;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        int lastIndex = -1;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int tmp = num;
            while (true) {
                if (res.size() == 0) {
                    res.add(tmp);
                    lastIndex++;
                    break;
                }
                int gcd = gcd(res.get(lastIndex), tmp);
                if (gcd > 1) {
                    tmp = (int) ((long) res.get(lastIndex) * tmp / gcd);
                    res.remove(lastIndex);
                    lastIndex--;
                } else {
                    res.add(tmp);
                    lastIndex++;
                    break;
                }
            }
        }
        return res;
    }
}
