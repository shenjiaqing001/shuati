/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/18/20
 */
public class lc1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int times = 1;
        while (candies >= (1 + times * num_people) * times * num_people / 2) {
            times++;
        }
        times--;

        for (int i = 0; i < num_people; ++i) {
            res[i] += times * (i + 1) + (times - 1) * times * num_people / 2;
        }
        if (times > 0)
            candies -= (1 + times * num_people) * times * num_people / 2;
        int start = times * num_people + 1;
        int index = 0;
        while (candies >= start) {
            res[index++] += start;
            candies -= start++;
        }
        res[index] += candies;
        return res;
    }
}
