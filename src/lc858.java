/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc858 {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (q % 2 == 0) return 0;
        return 1 + (p + q) % 2;
    }
}
