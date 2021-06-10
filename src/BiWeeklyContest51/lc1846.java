package BiWeeklyContest51;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int now = 1;
        arr[0] = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == now) {
            } else if (arr[i] == now + 1) {
                now += 1;
            } else if (arr[i] > now + 1) {
                arr[i] = now + 1;
                now += 1;
            }
        }
        return now;
    }
}

