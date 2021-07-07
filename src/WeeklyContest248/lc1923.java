package WeeklyContest248;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc1923 {
    public int longestCommonSubpath(int n, int[][] paths) {
        Arrays.sort(paths, (o1, o2) -> o1.length - o2.length);

        int lo = 0;
        int hi = paths[0].length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(lo + " " + hi + "  " + mid);
            if (check(paths, mid + 1)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    public boolean check(int[][] paths, int length) {
        long z = 1000000;
        long base = 100003;
        long mod = z * z + 39;
        Map<Long, Integer> map = new HashMap<>();

        long pow_base = 1;
        for (int i = 0; i < length; ++i) pow_base = pow_base * base % mod;

        for (int[] path : paths) {
            long hash = 0;
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < path.length; ++i) {
                hash = (hash * base + path[i]) % mod;
                if (i >= length) {
                    hash = (hash - pow_base * path[i - length]) % mod;
                    hash = (hash + mod) % mod;
                }

                if (i >= length - 1) {
                    set.add(hash);
                }
            }
            for (Long l : set) {
                map.put(l, map.getOrDefault(l, 0) + 1);
            }
        }

        for (Integer val : map.values()) {
            if (val == paths.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        lc1923 test = new lc1923();
        test.longestCommonSubpath(5,
                new int[][]{{0, 1, 2, 3, 4}, {2, 3, 4}, {4, 0, 1, 2, 3}});
    }
}
