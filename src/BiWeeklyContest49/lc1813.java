package BiWeeklyContest49;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/3
 */
public class lc1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] strs1 = sentence1.split(" ");
        String[] strs2 = sentence2.split(" ");
        if (strs1.length < strs2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int i = 0;
        while (i < strs2.length && strs2[i].equals(strs1[i])) {
            i++;
        }

        while (i < strs2.length && strs2[i].equals(strs1[strs1.length - strs2.length + 1])) {
            i++;
        }

        return i == strs2.length;
    }
}
