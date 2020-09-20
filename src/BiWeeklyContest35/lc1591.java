package BiWeeklyContest35;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/21
 */
public class lc1591 {
    public boolean isPrintable(int[][] targetGrid) {
        int x = targetGrid.length;
        int y = targetGrid[0].length;
        Set<Integer> colors = new HashSet<>();
        int[][] edge = new int[61][4];
        for (int i = 0; i <= 60; ++i) {
            edge[i][0] = x - 1;
            edge[i][1] = y - 1;
            edge[i][2] = 0;
            edge[i][3] = 0;
        }

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                int color = targetGrid[i][j];
                colors.add(color);
                edge[color][0] = Math.min(edge[color][0], i);
                edge[color][1] = Math.min(edge[color][1], j);
                edge[color][2] = Math.max(edge[color][2], i);
                edge[color][3] = Math.max(edge[color][3], j);
            }
        }

        while (true) {
            if (colors.size() == 0) return true;
            boolean flag = false;
            Set<Integer> now = new HashSet<>(colors);
            for (Integer color : colors) {
                boolean tmp = true;
                for (int i = edge[color][0]; i <= edge[color][2]; ++i) {
                    for (int j = edge[color][1]; j <= edge[color][3]; ++j) {
                        if (!(targetGrid[i][j] == color || targetGrid[i][j] == 0)) {
                            tmp = false;
                            break;
                        }
                    }
                    if (tmp == false) break;
                }
                if (tmp == false) continue;

                for (int i = edge[color][0]; i <= edge[color][2]; ++i) {
                    for (int j = edge[color][1]; j <= edge[color][3]; ++j) {
                        targetGrid[i][j] = 0;
                    }
                }
                now.remove(color);
                // System.out.println(color);
                flag = true;
            }
            colors = now;
//            System.out.println(colors.size());
            if (flag == false) {
//                System.out.println(colors.size());
//                System.out.println();
//                for(Integer color : colors)
//                    System.out.println(color);
//
//                for (int i = 0; i < x; ++i) {
//                    for (int j = 0; j < y; ++j) {
//                        int color = targetGrid[i][j];
//                        System.out.print(color + " ");
//                    }
//                    System.out.println();
//                }
                return false;
            }
        }
    }
}
