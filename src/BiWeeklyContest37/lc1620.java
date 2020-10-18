package BiWeeklyContest37;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/17
 */
public class lc1620 {
    /**
     * 1 <= towers.length <= 50
     * towers[i].length == 3
     * 0 <= xi, yi, qi <= 50
     * 1 <= radius <= 50
     */
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] map = new int[51][51];
        for (int i = 0; i < towers.length; ++i) {
            int x = towers[i][0];
            int y = towers[i][1];
            for (int j = x - radius; j <= x + radius; ++j) {
                if (j < 0 || j > 50) continue;
                for (int k = y - radius; k <= y + radius; ++k) {
                    if (k < 0 || k > 50) continue;
                    int xd = x - j;
                    int yd = y - k;
                    double d = Math.sqrt(xd * xd + yd * yd);
                    if (d <= (double) radius) {
                        map[j][k] += (int) (towers[i][2] / (1 + d));
                    }
                }
            }
        }

        int[] res = new int[2];
        int max = 0;
        for (int i = 0; i <= 50; ++i) {
            for (int j = 0; j <= 50; ++j) {
                if (map[i][j] > max) {
                    max = map[i][j];
                    res[0] = i;
                    res[1] = j;
                } else if (map[i][j] == max) {
                    if (i < res[0]) {
                        res[0] = i;
                        res[1] = j;
                    } else if (i == res[0]) {
                        if (j < res[1])
                            res[1] = j;
                    }
                }
            }
        }
        return res;
    }
}
