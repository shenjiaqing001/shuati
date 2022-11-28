package WeeklyContest318;

import java.io.PipedReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/5/22
 */
public class lc3 {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();
        long res = 0;
        int left = candidates;
        int right = costs.length - candidates - 1;
        for (int i = 0; i < left; i++) {
            pqLeft.add(costs[i]);
        }
        for (int i = Math.max(left, right + 1); i < costs.length; i++) {
            pqRight.add(costs[i]);
        }
        while (k > 0) {
            if (left > right) {
                if (pqLeft.isEmpty()) res += pqRight.poll();
                else if (pqRight.isEmpty()) res += pqLeft.poll();
                else {
                    if (pqLeft.peek() <= pqRight.peek()) {
                        res += pqLeft.poll();
                    } else {
                        res += pqRight.poll();
                    }
                }

            } else {
                if (pqLeft.peek() <= pqRight.peek()) {
                    res += pqLeft.poll();
                    pqLeft.add(costs[left++]);
                } else {
                    res += pqRight.poll();
                    pqRight.add(costs[right--]);
                }
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4);
    }

}
