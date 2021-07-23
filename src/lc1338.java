import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/7
 */
public class lc1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int total = arr.length;
        int[] count = new int[map.size()];
        int index = 0;
        for (int val : map.values()) {
            count[index++] = val;
        }
        Arrays.sort(count);
        int sum = 0;
        for (int i = count.length - 1; i >= 0; --i) {
            sum += count[i];
            if (sum >= total / 2) return count.length - i;
        }
        return 1;
    }
}
