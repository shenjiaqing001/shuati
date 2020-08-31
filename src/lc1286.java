import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/14/20
 */
public class lc1286 {

    class CombinationIterator {
        char[] string;
        int length = 0;
        int now = 0;
        int max = 0;
        List<Integer> list = new LinkedList<>();

        public CombinationIterator(String characters, int combinationLength) {
            this.string = characters.toCharArray();
            this.length = characters.length();

            for (int i = (1 << this.length) - 1; i > 0; --i) {
                if (countOnes(i) == combinationLength)
                    list.add(i);
            }
        }

        public int countOnes(int num) {
            int count = 0;
            while (num > 0) {
                if ((num & 1) == 1) count++;
                num >>= 1;
            }
            return count;
        }

        public String next() {
            int now = list.remove(0);
            String s = "";
            int tmp = length - 1;
            while (now > 0) {
                if ((now & 1) == 1) s = string[tmp] + s;
                now >>= 1;
                tmp--;
            }

            return s;
        }

        public boolean hasNext() {
            if (!list.isEmpty())
                return true;
            else
                return false;
        }
    }
}
