package WeeklyContest203;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/23/20
 */
public class lc3 {
    public int findLatestStep(int[] arr, int m) {
        int length = arr.length;
        int[] now = new int[length + 1];
        int max = -1;
        Map<Integer, Integer> beginmap = new HashMap<>();
        Map<Integer, Integer> endmap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 1; i <= length; ++i) {
            beginmap.put(i, i);
            endmap.put(i, i);
            countMap.put(i, 0);
        }
        countMap.put(0, 0);

        for (int i = 0; i < arr.length; ++i) {
            int nowPos = arr[i];
            now[nowPos] = 1;

            for (int j = 1; j <= length; ++j) {
                System.out.print(now[j] + " ");
            }
            System.out.println();


            if (nowPos > 0 && now[nowPos - 1] == 0 && nowPos < length &&
                    now[nowPos + 1] == 0) {
                countMap.put(1, countMap.get(1) + 1);
                if (countMap.get(m) > 0) {
                    max = i + 1;
                }
                beginmap.put(nowPos, nowPos);
                endmap.put(nowPos, nowPos);
                System.out.println(countMap.get(m));
                continue;
            }
            if ((nowPos == 0 && now[nowPos + 1] == 0) ||
                    (nowPos == length && now[nowPos - 1] == 0)) {
                countMap.put(1, countMap.get(1) + 1);
                if (countMap.get(m) > 0) {
                    max = i + 1;
                }
                beginmap.put(nowPos, nowPos);
                endmap.put(nowPos, nowPos);
                System.out.println(countMap.get(m));
                continue;
            }

            if (nowPos > 0 && now[nowPos - 1] == 1) {
                int begin = beginmap.get(nowPos - 1);
                beginmap.put(nowPos, begin);
                endmap.put(begin, nowPos);
                countMap.put(nowPos - begin, countMap.get(nowPos - begin) - 1);
                countMap.put(nowPos - begin + 1,
                        countMap.get(nowPos - begin + 1) + 1);
            }

            if (nowPos < length && now[nowPos + 1] == 1) {
                int begin = beginmap.get(nowPos);
                if (begin == nowPos)
                    countMap.put(1, countMap.get(1) + 1);
                int end = endmap.get(nowPos + 1);
                beginmap.put(end, begin);
                endmap.put(begin, end);
                countMap.put(end - nowPos, countMap.get(end - nowPos) - 1);
                countMap.put(nowPos - begin + 1,
                        countMap.get(nowPos - begin + 1) - 1);
                countMap.put(end - begin + 1,
                        countMap.get(end - begin + 1) + 1);
            }
            if (countMap.get(m) > 0) {
                max = i + 1;
            }
            System.out.println(countMap.get(m));
        }
        return max;
    }
}
