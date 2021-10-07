/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/7
 */
public class lc900 {
    class RLEIterator {
        int[] encoding;
        int index = 0;
        int last = 0;
        int number = 0;

        public RLEIterator(int[] encoding) {
            this.encoding = encoding;
            last = encoding[0];
            number = encoding[1];
            index = 2;
        }

        public int next(int n) {
            while (n > 0) {
                if (last >= n) {
                    last -= n;
                    n = 0;
                } else {
                    n -= last;
                    last = 0;
                    if (index >= encoding.length) {
                        return -1;
                    } else {
                        last = encoding[index];
                        number = encoding[index + 1];
                        index += 2;
                    }
                }
            }
            return number;
        }
    }

}
