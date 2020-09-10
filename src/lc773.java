import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc773 {
    public int slidingPuzzle(int[][] board) {
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }

        int[][] dir = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        q.add(sb.toString());
        set.add(sb.toString());
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; ++k) {
                String now = q.poll();
                if (now.equals("123450")) return step;
                System.out.println(now);

                int pos = 0;
                for (int i = 0; i < 6; ++i) {
                    if (now.charAt(i) == '0')
                        pos = i;
                }


                for (int next : dir[pos]) {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(now);
                    tmp.setCharAt(pos, tmp.charAt(next));
                    tmp.setCharAt(next, '0');
                    String str = tmp.toString();

                    if (!set.contains(str)) {
                        set.add(str);
                        q.add(str);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
