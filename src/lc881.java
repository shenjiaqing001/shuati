import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/30
 */
public class lc881 {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        while (left <= right) {
            System.out.println(left + " " + right);
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return res;
    }
}
