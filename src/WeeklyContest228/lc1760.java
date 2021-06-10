package WeeklyContest228;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/14
 */
public class lc1760 {
    public int minimumSize(int[] A, int k) {
        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int a : A)
                count += (a - 1) / mid;
            if (count > k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
