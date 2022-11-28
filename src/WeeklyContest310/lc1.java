package WeeklyContest310;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/10/22
 */
public class lc1 {
    public int mostFrequentEven(int[] nums) {
        int[] count = new int[100000 + 5];
        for (int num : nums) {
            count[num]++;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i <= 100000; ++i) {
            if (i % 2 == 0) {
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
        }
        return index;
    }
}
