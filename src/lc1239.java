import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/22
 */
public class lc1239 {
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (String string : arr) {
            int num = 0;
            boolean flag = true;
            for (char c : string.toCharArray()) {
                if ((num & (1 << (c - 'a'))) != 0) {
                    flag = false;
                    break;
                }
                num |= (1 << (c - 'a'));
            }
            if (flag) list.add(num);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer num : list) {
            Set<Integer> newSet = new HashSet<>(set);
            newSet.add(num);
            for (Integer n : set) {
                if ((num & n) == 0) {
                    newSet.add(num | n);
                }
            }
            set = newSet;
        }
        int max = 0;
        for (Integer num : set) {
            max = Math.max(max, Integer.bitCount(num));
        }
        return max;
    }
}
