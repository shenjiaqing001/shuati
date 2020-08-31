import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/18/20
 */
public class lc967 {
    public int[] numsSameConsecDiff(int length, int diff) {
        if (length == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 9; ++i) {
            recursion(length, diff, 1, i, list);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void recursion(int length, int diff, int now, int tmp,
                          List<Integer> list) {
        if (now == length) {
            list.add(tmp);
            return;
        }

        int last = tmp % 10;
        if (diff == 0) recursion(length, diff, now + 1, tmp * 10 + last, list);
        else {
            if (last - diff >= 0)
                recursion(length, diff, now + 1, tmp * 10 + last - diff, list);
            if (last + diff <= 9)
                recursion(length, diff, now + 1, tmp * 10 + last + diff, list);
        }
    }

    public static void main(String[] args) {
        lc967 t = new lc967();
        int[] res = t.numsSameConsecDiff(3, 7);
        for(int i : res)
            System.out.println(i);
    }
}
