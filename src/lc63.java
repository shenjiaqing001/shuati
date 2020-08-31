/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/20/20
 */
public class lc63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < map.length; ++i) {
            if (obstacleGrid[i][0] == 0)
                map[i][0] = 1;
            else
                break;
            ;
        }
        for (int i = 0; i < map[0].length; ++i) {
            if (obstacleGrid[0][i] == 0)
                map[0][i] = 1;
            else
                break;
        }
        for (int i = 1; i < map.length; ++i) {
            for (int j = 1; j < map[0].length; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }


        return map[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
