/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int x = 0;
        int y = 0;
        int face = 0;
        for (int i = 0; i < instructions.length(); ++i) {
            if (instructions.charAt(i) == 'L') {
                face = (face + 1) % 4;
            } else if (instructions.charAt(i) == 'R') {
                face = (face + 3) % 4;
            } else {
                x += dir[face][0];
                y += dir[face][1];
            }
        }

        return (x == 0 && y == 0) || face != 0;
    }

    public static void main(String[] args) {
        lc1041 t = new lc1041();
        System.out.println(t.isRobotBounded("GGRGGRGGRGGR"));
    }
}
