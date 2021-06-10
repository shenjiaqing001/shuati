package BiWeeklyContest51;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1847 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.sort(rooms, (o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < rooms.length; ++i) {
            treeSet.add(rooms[i][0]);
        }
        int n = queries.length;
        int[] res = new int[n];
        int[][] q = new int[n][3];
        for (int i = 0; i < n; ++i) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (o1, o2) -> o1[1] - o2[1]);
        int index = 0;
        for (int i = 0; i < n; ++i) {
            while (index < rooms.length && rooms[index][1] < q[i][1]) {
                treeSet.remove(rooms[index][0]);
                index++;
            }

            if (treeSet.isEmpty()) {
                res[q[i][2]] = -1;
            } else {
                if (treeSet.contains(q[i][0])) res[q[i][2]] = q[i][0];
                else if (treeSet.ceiling(q[i][0]) == null) res[q[i][2]] = treeSet.floor(q[i][0]);
                else if (treeSet.floor(q[i][0]) == null) res[q[i][2]] = treeSet.ceiling(q[i][0]);
                else {

                    int low = treeSet.floor(q[i][0]);
                    int high = treeSet.ceiling(q[i][0]);

                    if (Math.abs(low - q[i][0]) <= Math.abs(high - q[i][0]))
                        res[q[i][2]] = low;
                    else res[q[i][2]] = high;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc1847 test = new lc1847();
        int[][] a1 = new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 1}, {5, 2}};
        int[][] a2 = new int[][]{{2, 3}, {2, 4}, {2, 5}};
        test.closestRoom(a1, a2);
    }
}
