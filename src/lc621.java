/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        int max = 0;
        for (int i = 0; i < 26; ++i)
            max = Math.max(max, count[i]);
        int maxCount = 0;
        for (int i = 0; i < 26; ++i)
            if (max == count[i])
                maxCount++;


        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int slot = partCount * partLength;
        int avail = tasks.length - max * maxCount;
        int idles = Math.max(0, slot - avail);
        return tasks.length + idles;


    }
}
