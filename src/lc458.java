/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/16/20
 */
public class lc458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int waves = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while (Math.pow(waves, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
