package WeeklyContest225;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/24
 */
public class lc2 {
    public int minCharacters(String a, String b) {
        int[] aCount = new int[26];
        int[] bCount = new int[26];
        for (char c : a.toCharArray()) {
            aCount[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            bCount[c - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < 26; ++i) {
            min = Math.min(min, a.length() + b.length() - aCount[i] - bCount[i]);
            aSum += aCount[i];
            bSum += bCount[i];
            if (i < 25) {
                min = Math.min(min, a.length() - aSum + bSum);
                min = Math.min(min, b.length() - bSum + aSum);
            }
        }
        return min;
    }
}
