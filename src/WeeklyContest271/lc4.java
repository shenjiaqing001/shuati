package WeeklyContest271;

import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc4 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(-1, 0);
        int sum = 0;
        // position, amount
        for (int[] fruit : fruits) {
            sum += fruit[1];
            treeMap.put(fruit[0], sum);
        }
        treeMap.put(200001, sum);
        int floorKey1 = treeMap.floorKey(startPos - 1);
        int floorKey2 = treeMap.floorKey(startPos + k);
        int max = treeMap.get(floorKey2) - treeMap.get(floorKey1);

        floorKey1 = treeMap.floorKey(startPos);
        floorKey2 = treeMap.floorKey(Math.max(-1, startPos - k - 1));
        max = Math.max(max, treeMap.get(floorKey1) - treeMap.get(floorKey2));

        Integer floor = treeMap.floorKey(startPos - 1);
        while (floor != null && floor != -1 && floor + k >= startPos) {
            int distance = startPos - floor;
            int high = startPos + k - 2 * distance;
            int tmpHighKey = treeMap.floorKey(Math.max(high, startPos));
            int tmpLowKey = treeMap.floorKey(floor - 1);
            max = Math.max(max, treeMap.get(tmpHighKey) - treeMap.get(tmpLowKey));
            floor = treeMap.floorKey(floor - 1);
        }

        floor = treeMap.ceilingKey(startPos + 1);
        while (floor != null && floor != 200001 && floor - k <= startPos) {
            int distance = floor - startPos;
            int low = startPos - (k - 2 * distance);
            int tmpHighKey = treeMap.floorKey(floor);
            int tmpLowKey = treeMap.floorKey(Math.max(-1, low - 1));
            max = Math.max(max, treeMap.get(tmpHighKey) - treeMap.get(tmpLowKey));
            floor = treeMap.ceilingKey(floor + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        System.out.println(test.maxTotalFruits(new int[][]{{20000, 1}}, 20000, 0));
    }
}
