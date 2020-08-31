/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                return new int[]{i, j};

            if (numbers[i] + numbers[j] < target)
                i++;
            else {
                j--;
            }
        }
        return null;
    }
}
