import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/16/22
 */
public class lc2191_Biweekly73 {
    int[] mapping;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        Integer[] digits = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        final Comparator<Integer> arrayComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return mappedvalue(o1).compareTo(mappedvalue(o2));
            }
        };

        Arrays.sort(digits, arrayComparator);
        int[] array = Arrays.stream(digits).mapToInt(i -> i).toArray();
        return array;
    }

    private Integer mappedvalue(int value) {
        int answer = 0;
        int multiplier = 1;
        if (value == 0) {
            return mapping[0];
        }
        while (value > 0) {

            int digit = value % 10;
            value = value / 10;
            answer += mapping[digit] * multiplier;
            multiplier *= 10;
        }
        return answer;
    }
}
