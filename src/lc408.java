/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/1
 */
public class lc408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] cWord = word.toCharArray();
        char[] cAbbr = abbr.toCharArray();
        int indexWord = 0;
        int indexAbbr = 0;
        while (indexWord < cWord.length && indexAbbr < cAbbr.length) {
            if (cAbbr[indexAbbr] >= 'a' && cAbbr[indexAbbr] <= 'z') {
                if (cAbbr[indexAbbr++] != cWord[indexWord++]) {
                    return false;
                }
            } else {
                int num = -1;
                while (indexAbbr < cAbbr.length &&
                        (cAbbr[indexAbbr] >= '0' && cAbbr[indexAbbr] <= '9')) {
                    if (num == 0) return false;
                    if (num == -1) num = 0;
                    num = 10 * num + cAbbr[indexAbbr++] - '0';
                }
                if (num == 0) return false;
                indexWord += num;
            }
        }
//        System.out.println(indexWord + " " + indexAbbr);
        if (indexAbbr != abbr.length() || indexWord != word.length()) return false;
        return true;
    }
}
