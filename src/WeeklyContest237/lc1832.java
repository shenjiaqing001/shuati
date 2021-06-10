package WeeklyContest237;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/21
 */
public class lc1832 {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray())set.add(c);
        return set.size() == 26;
    }
}
