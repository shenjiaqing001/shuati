package OnlineAssessment.ByteDance2021Fall;

import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class oa4 {
    public int getIndex(List<Integer> magic, List<Integer> carpet) {
        int min = 0;
        int n = magic.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            magic.add(magic.get(i));
            carpet.add(carpet.get(i));
        }
        for (int i = 0; i < n - 1; ++i) {
            sum += magic.get(i);
            sum -= carpet.get(i + 1);
            min = Math.min(min, sum);
        }
        if (min >= 0) return 0;
        int tmp = 0;
        for (int i = 0; i < n; ++i) {
            tmp += carpet.get(i + 1) - magic.get(i);


        }

        return -1;
    }

}
