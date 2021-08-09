package BiWeeklyContest57;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc2 {
    public int smallestChair(int[][] times, int targetFriend) {
        int res = times[targetFriend][0];
        // arriving time, leaving time, friendIndex
        Arrays.sort(times, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        // leaving time, chairIndex
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < times.length; ++i) free.add(i);
        for (int i = 0; i < times.length; ++i) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                free.add(pq.poll()[1]);
            }
            int chair = free.poll();
            if (times[i][0] == res) return chair;
            pq.add(new int[]{times[i][1], chair});
        }
        return -1;
    }

    public int smallestChair2(int[][] times, int targetFriend) {
        int resA = times[targetFriend][0];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.sort(times, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

        for (int i = 0; i < times.length; i++) {
            treeSet.add(i);
            while (!pq.isEmpty()) {
                System.out.println(times[i][0] + " " + pq.peek()[1]);
                if (times[i][0] < pq.peek()[1]) {
                    break;
                } else {
                    treeSet.add(map.get(pq.poll()[0]));
                }
            }

            if (times[i][0] != resA) break;

            int a = treeSet.pollFirst();
            map.put(times[i][0], a);
            pq.add(times[i]);
        }

        return treeSet.first();
    }
}
