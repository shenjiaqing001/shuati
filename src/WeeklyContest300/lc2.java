package WeeklyContest300;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/2/22
 */
public class lc2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = -1;
            }
        }
        int already = 0;
        int[][] dirctions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int i = 0;
        int j = 0;
        while (true) {
            res[i][j] = head.val;
            already++;
            if (already == m * n) break;
            int nx = i + dirctions[d][0];
            int ny = j + dirctions[d][1];
            while (nx >= m || ny >= n || nx < 0 || ny < 0 || res[nx][ny] != -1) {
                d++;
                if (d == 4) d = 0;
                nx = i + dirctions[d][0];
                ny = j + dirctions[d][1];
            }
            i = nx;
            j = ny;
            if (head.next == null) break;
            head = head.next;
        }
        return res;
    }
}
