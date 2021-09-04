package BiWeeklyContest60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        int n = land.length;
        int m = land[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (land[i][j] == 1) {
                    int ii = i;
                    int jj = j;
                    while (ii + 1 < n && land[ii + 1][j] == 1) ii++;
                    while (jj + 1 < m && land[i][jj + 1] == 1) jj++;
                    res.add(new int[]{i, j, ii, jj});
                    for (int iii = i; iii <= ii; ++iii) {
                        for (int jjj = j; jjj <= jj; ++jjj) {
                            land[iii][jjj] = 0;
                        }
                    }
                }
            }
        }
        int[][] resArray = new int[res.size()][4];
        for (int i = 0; i < res.size(); ++i) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}
