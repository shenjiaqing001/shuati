/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lettersCount = new int[26];
        for (char c : letters) lettersCount[c - 'a']++;

        return dfs(words, lettersCount, score, new int[26], 0);
    }

    public int dfs(String[] words, int[] lettersCount, int[] score, int[] wordsCount, int index) {
        if (index == words.length) {
            int res = 0;
            for (int i = 0; i < 26; ++i) {
                if (wordsCount[i] > lettersCount[i]) return 0;
                res += wordsCount[i] * score[i];
            }
            return res;
        }

        int max = dfs(words, lettersCount, score, wordsCount, index + 1);

        for (char c : words[index].toCharArray()) {
            wordsCount[c - 'a']++;
        }
        max = Math.max(max, dfs(words, lettersCount, score, wordsCount, index + 1));
        for (char c : words[index].toCharArray()) {
            wordsCount[c - 'a']--;
        }
        return max;
    }

}
