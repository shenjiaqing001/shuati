package OnlineAssessment.Circle;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/1
 */
public class q3 {
    int solve(int n, int m, int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 + y1 - x2 - y2) % 2 == 1) return -1;

        int[] dir = new int[]{1, 1};
        int[] cur = new int[]{x1, y1};
        int count = 0;
        int res = 0;
        while (true) {
            res++;

            if (cur[0] + dir[0] < 0 || cur[0] + dir[0] >= n) {
                dir[0] = -dir[0];
            }
            if (cur[1] + dir[1] < 0 || cur[1] + dir[1] >= m) {
                dir[1] = -dir[1];
            }


        }

    }
}
