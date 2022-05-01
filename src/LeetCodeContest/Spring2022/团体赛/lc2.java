package LeetCodeContest.Spring2022.团体赛;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/23/22
 */
public class lc2 {
    public void trace(){

    }

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        char[][] map = new char[matrix.length][];
        for (int i = 0; i < matrix.length; ++i) {
            map[i] = matrix[i].toCharArray();
        }
        //<^v>
        int steps = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] flag = new boolean[map.length][map[0].length];
        q.add(end);
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {


            }
            break;
        }

        return steps;
    }
}
