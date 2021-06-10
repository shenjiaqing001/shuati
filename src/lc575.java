import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/5
 */
public class lc575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int type : candyType) {
            set.add(type);
        }
        return Math.min(set.size(), candyType.length / 2);
    }


}
