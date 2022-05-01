package WeeklyContest290;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/23/22
 */
public class lc1 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < n; ++i) {
            sets[i] = new HashSet<>();
            for (int num : nums[i]) {
                sets[i].add(num);
            }
        }

        for (int num : sets[0]) {
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if (!sets[i].contains(num)) flag = false;
            }
            if (flag) list.add(num);
        }
        list.sort(Comparator.comparingInt(o -> o));

        return list;
    }
}
