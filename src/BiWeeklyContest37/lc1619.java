package BiWeeklyContest37;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/17
 */
public class lc1619 {
    public double trimMean(int[] arr) {
        int length = arr.length / 20;
        Arrays.sort(arr);
        double sum = 0.0;
        for (int i = length; i < arr.length - length; ++i) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * length);
    }
}
