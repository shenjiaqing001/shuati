/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/9
 */
public class lc616 {
    public String addBoldTag(String s, String[] words) {
        int length = s.length();
        boolean[] flag = new boolean[length];

        for (String word : words) {
            int index = -1;

            while ((index = s.indexOf(word, index+1)) != -1) {

                for (int i = index; i < index + word.length(); ++i) {
                    flag[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean tmp = false;
        for (int i = 0; i < s.length(); ++i) {
            if (flag[i] != tmp) {
                if (tmp) {
                    sb.append("</b>");
                } else {
                    sb.append("<b>");
                }
                tmp = !tmp;
            }
            sb.append(s.charAt(i));
        }
        if (tmp) sb.append("</b>");
        return sb.toString();
    }
}
