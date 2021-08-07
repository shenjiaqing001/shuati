import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/6
 */
public class lc1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int horiMax = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; ++i) {
            horiMax = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], horiMax);
        }
        horiMax = Math.max(horiMax, h - horizontalCuts[horizontalCuts.length - 1]);

        int vertMax = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; ++i) {
            vertMax = Math.max(verticalCuts[i] - verticalCuts[i - 1], vertMax);
        }
        vertMax = Math.max(vertMax, w - verticalCuts[verticalCuts.length - 1]);

        int res = (int) ((long) horiMax * (long) vertMax % (long) 1_000_000_007);
        return res;
    }
}
