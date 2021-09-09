package mock.day0904;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class q2 {
    //一群古惑仔年纪又大又小，同时给出武力值和年龄，要求大哥武力值>=二哥，二哥武力值>=三弟，求最大的武力值

    // 0 age,  1 hp
    public int solve(int[][] persons) {
        Arrays.sort(persons, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));

        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        for (int[] person : persons) {
            while (!deque.isEmpty() && deque.peekLast() < person[1]) deque.pollLast();
            deque.add(person[1]);
            if (deque.size() > 3) deque.pollLast();
            if (deque.size() == 3) {
                int sum = 0;
                for (int num : deque) sum += num;
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
