package WeeklyContest318;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/5/22
 */
public class lc4 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(((o1, o2) -> (o1 - o2)));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] f : factory) {
            if (f[1] != 0) {
                map.put(f[0], f[1]);
            }
        }
        TreeMap<Integer, Integer> toRightT = new TreeMap<>();
        long res = 0;
        for (int r : robot) {
            Long left = Long.MAX_VALUE;
            Long right = Long.MAX_VALUE;
            long countLeft = 0;
            if (map.ceilingKey(r) != null) {
                Integer key = map.ceilingKey(r);
                right = (long) (key - r);
            }
            TreeMap<Integer, Integer> toRight = new TreeMap<>(toRightT);

            if (map.floorKey(r) != null) {
                Integer key = map.floorKey(r);
                left = (long) (r - key);
                Integer entry = toRight.floorKey(r);
                int leftNode = r;
                while (entry != null) {
                    int start = entry;
                    int end = toRight.get(start);
                    if (end <= key) break;
                    toRight.remove(start);
                    if (end > leftNode) {
                        toRight.put(leftNode, end);
                    }
                    if (start < key) {
                        toRight.put(start, key);
                    }
                    countLeft += Math.min(leftNode, end) - Math.max(start, key);
                    leftNode = Math.max(start, key);
                    if (start < key) break;
                    entry = toRight.floorKey(start - 1);
                }

            }
            if (left - 2 * countLeft < right) {
                res += left - 2 * countLeft;
                toRightT = toRight;
                Integer key = map.floorKey(r);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);
                System.out.println(robot + " " +  key);
            } else {
                res += right;
                Integer key = map.ceilingKey(r);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);
                if (key != r) {
                    toRightT.put(r, key);
                }
                System.out.println(robot + " " +  key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        List<Integer> robot = new ArrayList<>();
        //323190444,534058139,-684109467,425503766,761908175
        robot.add(-333539942);
        robot.add(359275673);
        robot.add(89966494);
        robot.add(949684497);

        robot.add(241002388);
        robot.add(-733065249);
        robot.add(325009248);
        robot.add(403868412);

        robot.add(-390719486);
        robot.add(-670541382);
        robot.add(563735045);
        robot.add(119743141);

        robot.add(323190444);

        robot.add(534058139);
        robot.add(-684109467);
        robot.add(425503766);
        robot.add(761908175);

        test.minimumTotalDistance(robot,
                new int[][]{{-80676932,3}, {480747884,9}, {118956496,10}});
    }
}
