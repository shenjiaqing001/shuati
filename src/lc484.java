import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc484 {
    public int[] findPermutation(String s) {
        char[] c = (s + "I").toCharArray();
        int[] res = new int[c.length];
        int tmp = 0;
        int num = 1;

        while (tmp < c.length) {
            if (c[tmp] == 'I') {
                res[tmp++] = num++;
            } else {
                int endPos = tmp;
                while (c[endPos] == 'D')
                    endPos++;
                for (int j = endPos; j >= tmp; --j)
                    res[j] = num++;
                tmp = endPos + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc484 t = new lc484();
        int[] res = t.findPermutation("IDID");
        for (int i : res) System.out.println(i);
    }
}
