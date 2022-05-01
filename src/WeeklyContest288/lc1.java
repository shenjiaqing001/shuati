package WeeklyContest288;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/9/22
 */
public class lc1 {
    public int largestInteger(int num) {
        List<Integer> pqOdd = new ArrayList<>();
        List<Integer> pqEven = new ArrayList<>();

        String str = String.valueOf(num);
        char[] chars = str.toCharArray();

        for (char c : chars) {
            int cur = c - '0';
            if ((cur) % 2 == 0) {
                pqEven.add(cur);
            } else {
                pqOdd.add(cur);
            }
        }
        pqOdd.sort((a, b) -> (b - a));
        pqEven.sort((a, b) -> (b - a));

        StringBuilder sb = new StringBuilder();
        int evenIndex = 0;
        int oddIndex = 0;
        for (char c : chars) {
            int cur = c - '0';
            if ((cur) % 2 == 0) {
                sb.append(pqEven.get(evenIndex++));
            } else {
                sb.append(pqOdd.get(oddIndex++));
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
