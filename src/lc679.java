import javafx.beans.binding.DoubleExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/24
 */
public class lc679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            list.add((double) nums[i]);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) <= 0.001) return true;
            else return false;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                Double p1 = list.get(i), p2 = list.get(j);
                next.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));
                if (Math.abs(p2) > 0.001) next.add(p1 / p2);
                if (Math.abs(p1) > 0.001) next.add(p2 / p1);

                list.remove(i);
                list.remove(j);
                for (Double n : next) {
                    list.add(n);
                    if (dfs(list)) return true;
                    list.remove(list.size() - 1);
                }
                list.add(j, p2);
                list.add(i, p1);
            }
        }
        return false;
    }
}
