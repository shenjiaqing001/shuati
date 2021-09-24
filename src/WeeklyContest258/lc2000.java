package WeeklyContest258;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc2000 {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, index + 1));
        sb = sb.reverse();
        return sb.toString() + word.substring(index + 1);
    }
}
