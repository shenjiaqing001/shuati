import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/3
 */
public class lc843 {
    public int matches(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int count = 0;
        for (int i = 0; i < 6; ++i) {
            if (ca[i] == cb[i]) {
                count++;
            }
        }
        return count;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new ArrayList<>(List.of(wordlist));

        for (int i = 0; i < 10; ++i) {
            String s = words.get(new Random().nextInt(words.size()));
            int match = master.guess(s);
            if (match == 6) return;
            List<String> tmp = new ArrayList<>();
            for (String word : words) {
                if (matches(word, s) == match) {
                    tmp.add(word);
                }
            }
            words = tmp;
        }
    }

    interface Master {
        public default int guess(String word) {
            return 0;
        }
    }
}
