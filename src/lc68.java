import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = left;
        int length = 0;
        while (left < words.length && right < words.length) {
            if (length == 0) {
                length = words[left].length();
                right = left + 1;
            } else {
                length += words[right].length();
                length += 1;
                if (length > maxWidth) {
                    res.add(makeOneLine(words, left, right - 1, maxWidth));
                    left = right;
                    length = 0;
                    right = 0;
                } else {
                    right++;
                }
            }
        }

        if (right == 0)
            return res;
        else {
            String str = words[left];
            for (int i = left + 1; i < right; ++i) {
                str = str + " " + words[i];
            }
            while (str.length() != maxWidth)
                str = str + " ";
            res.add(str);
            return res;
        }
    }

    public String makeOneLine(String[] words, int start, int end,
                              int maxWidth) {
        if (start == end) {
            String str = words[start];
            while (str.length() != maxWidth)
                str = str + " ";
            return str;
        }
        int totalLength = 0;
        for (int i = start; i <= end; ++i) {
            totalLength += words[i].length();
        }
        int devide = (maxWidth - totalLength) / (end - start);
        int remain = (maxWidth - totalLength) % (end - start);
        String str = words[start];

        for (int i = start + 1; i <= end; ++i) {
            for (int j = 0; j < devide; ++j)
                str = str + " ";
            if (i - start <= remain)
                str = str + " ";
            str = str + words[i];
        }
        return str;
    }


    public static void main(String[] args) {
        lc68 t = new lc68();
        String[] str =
                new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(t.fullJustify(str, 16));
    }
}
