package WeeklyContest207;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/20
 */
public class lc5519 {
    public String reorderSpaces(String text) {
        int totalLength = text.length();
        String[] strs = text.strip().split(" ");

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        List<String> wordlist = new LinkedList<>();
        for (String s : strs) {
            if (s.equals("")) continue;
            sum += s.length();
            wordlist.add(s);
        }
        if (wordlist.size() == 1) {
            sb.append(wordlist.get(0));
            for (int i = 0; i < totalLength - sum; ++i) sb.append(" ");
            return sb.toString();
        }

        int blanks = totalLength - sum;
        int each = blanks / (wordlist.size() - 1);
        int remain = blanks % (wordlist.size() - 1);
//        System.out.println(blanks + " " + each + " " + remain);
        for (String st : wordlist) System.out.println(st);

        sb.append(wordlist.get(0));
        for (int i = 1; i < wordlist.size(); ++i) {
            for (int j = 0; j < each; ++j) sb.append(" ");
            sb.append(wordlist.get(i));
        }
        for (int i = 0; i < remain; ++i) sb.append(" ");

        return sb.toString();
    }
}
