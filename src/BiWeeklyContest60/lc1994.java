package BiWeeklyContest60;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1994 {
    // [5,10,1,26,24,21,24,23,11,12,27,4,17,16,2,6,1,1,6,8,13,30,24,20,2,19]
    public static void main(String[] args) {
        lc1994 test = new lc1994();
        System.out.println(test.numberOfGoodSubsets(
                new int[]{5, 10, 1, 26, 24, 21, 24, 23, 11, 12, 27, 4, 17, 16, 2, 6, 1, 1, 6, 8, 13, 30, 24, 20, 2, 19}));
    }

    public int numberOfGoodSubsets(int[] nums) {
        long[] count = new long[31];
        for (int num : nums) {
            count[num]++;
        }
        long mod = 1_000_000_007;
        long res = 0;
        int[] determine =
                new int[]{2, 3, 5, 6, 7, 10, 11, 13, 14, 15, 21, 22, 26, 30, 17, 19, 23, 29};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : determine) map.put(num, new ArrayList<>());
        map.get(2).add(2);
        map.get(3).add(3);
        map.get(5).add(5);
        map.get(6).add(2);
        map.get(6).add(3);
        map.get(7).add(7);
        map.get(10).add(2);
        map.get(10).add(5);
        map.get(11).add(11);
        map.get(13).add(13);
        map.get(14).add(2);
        map.get(14).add(7);
        map.get(15).add(3);
        map.get(15).add(5);
        map.get(21).add(3);
        map.get(21).add(7);
        map.get(22).add(2);
        map.get(22).add(11);
        map.get(26).add(2);
        map.get(26).add(13);
        map.get(30).add(2);
        map.get(30).add(3);
        map.get(30).add(5);

        List<List<Integer>> numLists = new ArrayList<>();
        dfs(numLists, determine, 0, new HashSet<>(), map, new ArrayList<>());

        for (List<Integer> list : numLists) {
            if (list.size() == 0) continue;
            boolean flag = true;
            for (int num : list) {
                if (count[num] == 0) flag = false;
            }
            if (flag) {
                long sum = 1;
                for (int num : list) {
                    sum *= count[num];
                    sum %= mod;
                }
                res += sum;
                res %= mod;
            }
        }

        for (int i = 0; i < count[1]; ++i) {
            res *= 2;
            res %= mod;
        }

        return (int) res;
    }

    public void dfs(List<List<Integer>> numLists, int[] determine, int index, Set<Integer> set,
                    Map<Integer, List<Integer>> map, List<Integer> list) {
        if (index == determine.length) {
            numLists.add(new ArrayList<>(list));
            return;
        }

        dfs(numLists, determine, index + 1, set, map, list);
        boolean flag = true;
        for (int num : map.get(determine[index])) {
            if (set.contains(num)) flag = false;
        }
        if (flag) {
            set.addAll(map.get(determine[index]));
            list.add(determine[index]);
            dfs(numLists, determine, index + 1, set, map, list);
            map.get(determine[index]).forEach(set::remove);
            list.remove(list.size() - 1);
        }
    }
}
