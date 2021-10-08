/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/7
 */
public class lc418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int row = 0;
        int col = 0;
        int index = 0;
        int res = 0;
        while (row < rows) {
            int length = sentence[index].length();
            if (col + length <= cols) {
                col += length;
                index++;
                col += 1;
            } else {
                col = 0;
                row += 1;
            }
            if (index == sentence.length) {
                res++;
                index = 0;
            }
        }
        return res;
    }
}
