/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/10
 */
public class lc780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx) {
            if (sy > ty) return false;
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            if (sx > tx) return false;
            return (tx - sx) % sy == 0;
        }

        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;
            if (tx < ty) ty -= tx;
            else tx -= ty;
        }
        return false;
    }
}
