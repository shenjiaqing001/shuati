package mock.day1023;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class q1 {

    // 给一系列水果信息[cost, size, num] 表示一种水果的单价、单个体积和数量。
    // 现在有k个篮子，每个篮子的体积容量是capacity。
    // 有如下要求：
    // 1。 每个篮子只能装一种水果。
    // 2。 要求总体积最大。
    // 3。 满足要求1和2的前提下，要求总价格最便宜。
    // 求买到总体积最大水果的最小代价。

    public int compete(int[][] fruits, int capacity, int k) {
        // size, value, how many
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cmp = Integer.compare(o1[0], o2[0]);
                if (cmp == 0) {
                    cmp = Integer.compare(o1[1], o2[1]);
                }
                return cmp;
            }
        });

        // fruit: size value num
        for (int[] fruit : fruits) {
            if (fruit[0] > capacity) continue;
            int num = capacity / fruit[0];
            int howManyBaskets = fruit[2] / num;
            int remain = fruit[2] % num;
            pq.add(new int[]{num * fruit[0], num * fruit[1], howManyBaskets});
            if (remain != 0) {
                pq.add(new int[]{remain * fruit[0], remain * fruit[1], 1});
            }
        }

        int res = 0;
        while (k > 0 && !pq.isEmpty()) {
            int[] now = pq.poll();
            if (k >= now[2]) {
                res += now[1] * now[2];
                k -= now[2];
            } else {
                res += now[1] * k;
                k = 0;
            }
        }
        return res;
    }


}
