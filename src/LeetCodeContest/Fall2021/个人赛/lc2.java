package LeetCodeContest.Fall2021.个人赛;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc2 {
    public int maxmiumScore(int[] cards, int cnt) {
        PriorityQueue<Integer> pqOdd = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqEven = new PriorityQueue<>(Collections.reverseOrder());
        for (int card : cards) {
            if (card % 2 == 0) pqEven.add(card);
            else pqOdd.add(card);
        }

        int res = 0;
        if (cnt % 2 == 1) {
            if (pqEven.isEmpty()) return 0;
            else {
                res += pqEven.poll();
                cnt--;
            }
        }

        while (cnt > 0) {
            if (pqEven.size() < 2) {
                if (pqOdd.size() < 2) return 0;
                res += pqOdd.poll();
                res += pqOdd.poll();
                cnt -= 2;
                continue;
            }
            if (pqOdd.size() < 2) {
                if (pqEven.size() < 2) return 0;
                res += pqEven.poll();
                res += pqEven.poll();
                cnt -= 2;
                continue;
            }

            int odd1 = pqOdd.poll();
            int odd2 = pqOdd.poll();
            int even1 = pqEven.poll();
            int even2 = pqEven.poll();
            if (odd1 + odd2 >= even1 + even2) {
                res += odd1 + odd2;
                pqEven.add(even1);
                pqEven.add(even2);
            } else {
                res += even1 + even2;
                pqOdd.add(odd1);
                pqOdd.add(odd2);
            }
            cnt -= 2;
        }
        return res;
    }
}
