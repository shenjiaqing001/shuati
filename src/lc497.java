import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc497 {
    public class Solution {
        Random random;
        int[][] rects;

        public Solution(int[][] rects) {
            random = new Random();
            this.rects = rects;
        }

        public int[] pick() {
            int sum = 0;
            // the idx of rect that will be selected
            int idx = 0;
            for (int i = 0; i < rects.length; i++) {
                int[] r = rects[i];
                int w = r[2] - r[0] + 1;
                int l = r[3] - r[1] + 1;
                // count of points
                int count = w * l;
                sum += count;
                if (random.nextInt(sum) < count) idx = i;
            }

            int x = rects[idx][0] +
                    random.nextInt(rects[idx][2] - rects[idx][0] + 1);
            int y = rects[idx][1] +
                    random.nextInt(rects[idx][3] - rects[idx][1] + 1);

            return new int[]{x, y};
        }
    }
}