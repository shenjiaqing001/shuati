/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/21
 */
public class lc1275 {
    public String tictactoe(int[][] moves) {
        int[][] map = new int[3][3];
        for (int i = 0; i < moves.length; ++i) {
            if (i % 2 == 0) {
                map[moves[i][0]][moves[i][1]] = 1;
            } else {
                map[moves[i][0]][moves[i][1]] = 2;
            }
        }

        for (int i = 0; i < 3; ++i) {
            if (map[i][0] != 0) {
                if (map[i][0] == map[i][1] && map[i][0] == map[i][2]) {
                    return map[i][0] == 1 ? "A" : "B";
                }
            }
            if (map[0][i] != 0) {
                if (map[0][i] == map[1][i] && map[0][i] == map[2][i]) {
                    return map[0][i] == 1 ? "A" : "B";
                }
            }
        }

        if (map[1][1] != 0) {
            if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                return map[1][1] == 1 ? "A" : "B";
            }
            if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                return map[1][1] == 1 ? "A" : "B";
            }
        }
        if (moves.length == 9) return "Draw";
        else return "Pending";
    }
}
