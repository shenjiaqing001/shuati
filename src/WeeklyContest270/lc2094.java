package WeeklyContest270;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/4/21
 */
public class lc2094 {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < digits.length; ++i) {
            for (int j = 0; j < digits.length; ++j) {
                for (int k = 0; k < digits.length; ++k) {
                    if (i != j && j != k && i != k) {
                        int num = 100 * digits[i] + 10 * digits[j] + digits[k];
                        if (num < 100) continue;
                        if (num % 2 == 0 ) {
                            list.add(num);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) return new int[]{};
        int[] res = new int[list.size()];
        int index = 0;
        for (int num : list) res[index++] = num;
        Arrays.sort(res);
        return res;
    }
}
