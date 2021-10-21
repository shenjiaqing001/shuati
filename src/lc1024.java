import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/20
 */
public class lc1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (o1, o2) -> (o1[0] - o2[0]));
        int now = 0;
        int index = 0;
        int res = 0;
        while (now < time) {
            if (index == clips.length) return -1;
            if (now < clips[index][0]) return -1;
            int max = clips[index][1];
            while (index < clips.length && clips[index][0] <= now) {
                max = Math.max(max, clips[index][1]);
                index++;
            }
            now = max;
            res++;
        }
        return res;
    }
}
