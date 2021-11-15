package mock.day1113;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class q3 {
    //现在有n个人出发去迪士尼，已知他们的到达时间在[start, end]之间，如果同时n个人到达，那么他们进入队伍的顺序是任意的
    // 先给出一个k，问m每个人是否有可能是队伍中第k个人。
    // 【1，3】【4，4】【3，4】 k = 2 , [T, T, T]

    //最早可能是第几个，最晚可能是第几个，分别用start time和end time。。用diff array 或者线段树？
    //一个start time的，一个end time的，然后对于每个人用start time 去end array里面找和用end time 去start array里面找，可以知道最早和最晚。。

    //          1 2 3 4
    // start    1 0 2 3
    // end      0 0 2 3
    //

    public boolean[] solve(int[][] people, int k) {
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
        TreeMap<Integer, Integer> endMap = new TreeMap<>();
        int n = people.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        int index = 0;
        for (int[] p : people) {
            startTime[index] = p[0];
            endTime[index] = p[1];
            index++;
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        for (int num : startTime) {
            if (startMap.floorKey(num) == null) startMap.put(num, 1);
            else {
                int key = startMap.floorKey(num);
                int value = startMap.get(key);
                startMap.put(num, value + 1);
            }
        }
        for (int num : endTime) {
            if (endMap.floorKey(num) == null) endMap.put(num, 1);
            else {
                int key = endMap.floorKey(num);
                int value = endMap.get(key);
                endMap.put(num, value + 1);
            }
        }
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int max = n;
            if (endMap.ceilingKey(people[i][0] + 1) != null) {
                int key = endMap.ceilingKey(people[i][0] + 1);
                max = endMap.get(key) - 1;
            }
            int min = 0;
            if (startMap.floorKey(people[i][1] - 1) != null) {
                int key = startMap.floorKey(people[i][1] - 1);
                max = startMap.get(key) + 1;
            }
            if (min <= k && k <= max) {
                res[i] = true;
            }
        }
        return res;
    }
}
