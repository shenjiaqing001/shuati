/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/24/21
 */
public class lc789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int res = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int dist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (dist <= res) return false;
        }
        return true;
    }
}
