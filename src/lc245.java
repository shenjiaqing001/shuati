/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/21
 */
public class lc245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        if (!word1.equals(word2)) {
            for (int i = 0; i < words.length; ++i) {
                if (words[i].equals(word1)) {
                    index1 = i;
                    if (index2 != -1) min = Math.min(min, Math.abs(index1 - index2));
                }
                if (words[i].equals(word2)) {
                    index2 = i;
                    if (index1 != -1) min = Math.min(min, Math.abs(index1 - index2));
                }
            }
        } else {
            for (int i = 0; i < words.length; ++i) {
                if (words[i].equals(word1)) {
                    if (index1 == -1) index1 = i;
                    else if (index2 == -1) index2 = i;
                    else {
                        if (index1 < index2) index1 = i;
                        else if (index1 > index2) index2 = i;
                    }
                    if (index1 != -1 && index2 != -1) min = Math.min(min, Math.abs(index1 - index2));
                }
            }
        }
        return min;
    }
}
