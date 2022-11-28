/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/23/22
 */
public class lc2237 {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] count = new int[100005];
        for (int[] light : lights) {
            count[Math.max(light[0] - light[1], 0)]++;
            count[Math.min(light[0] + light[1] + 1, 100000)]--;
        }
        int res = 0;
        int sum = 0;
        for (int i = 0; i < requirement.length; ++i) {
            sum += count[i];
            if (sum >= requirement[i]) res++;
        }
        return res;
    }
}
