package WeeklyContest257;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1998 {

    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(10000 + 1);

        for (int num : nums) {
            int tmp = num;
            for (int i = 2; uf.p[tmp] == tmp && i * i <= tmp; ++i) {
                if (tmp % i == 0) {
                    uf.union(num, i);
                    while (tmp % i == 0) tmp /= i;
                }
            }
            if (tmp != 1) uf.union(tmp, num);
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < n; ++i) {
            if (uf.get(nums[i]) != uf.get(sorted[i])) return false;
        }
        return true;
    }

    public class UnionFind {
        int[] p;

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; ++i) p[i] = i;
        }

        public int get(int x) {
            return p[x] == x ? x : (p[x] = get(p[x]));
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p[a] < p[b]) p[b] = p[a];
            else p[a] = p[b];
        }
    }

}
