package WeeklyContest243;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/29
 */
public class lc1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = 0;
        int b = 0;
        int d = 0;

        for (char c : firstWord.toCharArray()) {
            a = 10 * a + (c - 'a');
        }
        for (char c : secondWord.toCharArray()) {
            b = 10 * b + (c - 'a');
        }

        for (char c : targetWord.toCharArray()) {
            d = 10 * d + (c - 'a');
        }


        return a + b == d;
    }
}
