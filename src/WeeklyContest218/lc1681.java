package WeeklyContest218;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/7
 */
public class lc1681 {
    int N;
    Map<String, Integer> memo;
    int k;

    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        k = k;
        int[] count = new int[17];
        for (int num : nums)
            if (++count[num] > k)
                return -1;  // if same number more than k times, we can not answer the question cause there must be one bucket with same number twice
        N = nums.length / k;   //N is the number of element in each bucket
        return dfs(new HashSet<>(), count);
    }

    private int dfs(Set<Integer> level, int[] count) {
        if (level.size() == N)
            return end(count) ? findDiff(level) : findDiff(level) + dfs(new HashSet<>(), count);
        String key = Arrays.hashCode(count) + " " +
                level; //count is remaining element status, level is current hand bucket element
        if (memo.containsKey(key)) return memo.get(key);
        int res = 1000;
        for (int i = 1; i <= 16; i++) {
            if (count[i] <= 0) continue; //no more this number left
            if (!level.add(i)) continue; //at hand same number already exist
            count[i]--;
            res = Math.min(res, dfs(level, count));
            count[i]++;
            level.remove(i);
            if (level.size() == 0) break;   // first element we don't need to expand
        }
        memo.put(key, res);
        return res;
    }

    private int findDiff(Set<Integer> level) {
        return Collections.max(level) - Collections.min(level);
    }

    private boolean end(int[] count) {
        for (int c : count) if (c != 0) return false;
        return true;
    }
}
