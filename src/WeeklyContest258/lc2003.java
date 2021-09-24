package WeeklyContest258;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc2003 {
    public static void main(String[] args) {
        lc2003 test = new lc2003();
        test.smallestMissingValueSubtree(new int[]{-1, 0, 0, 2}, new int[]{1, 2, 3, 4});
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int one = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                one = i;
                break;
            }
        }
        if (one == -1) return res;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.putIfAbsent(parents[i], new HashSet<>());
            map.get(parents[i]).add(i);
        }

        Set<Integer> set = new HashSet<>();
        int lastFound = 1;
        while (one != -1) {
            dfs(map, set, nums, one);
            while (set.contains(lastFound)) lastFound++;
            res[one] = lastFound;
            one = parents[one];
        }
        return res;
    }

    public void dfs(Map<Integer, Set<Integer>> map, Set<Integer> set, int[] nums, int root) {
        if (set.contains(nums[root])) return;
        set.add(nums[root]);
        if (map.containsKey(root) && map.get(root).size() > 0) {
            for (Integer child : map.get(root)) {
                dfs(map, set, nums, child);
            }
        }
    }
}
