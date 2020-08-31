package WeeklyContest204;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc1 {

    public boolean containsPattern(int[] arr, int m, int k) {
        int begin = 0;

        while (begin + m * k <= arr.length) {
            boolean flag = true;
            for (int i = begin; i < begin + m; ++i) {
                boolean tmp = true;
                int num = arr[i];
                for (int j = 1; j < k; ++j) {
                    if (arr[i + m * j] != num)
                        tmp = false;
                }
                if (tmp == false)
                    flag = false;
            }
            if (flag == true)
                return true;
            begin++;
        }
        return false;
    }


}
