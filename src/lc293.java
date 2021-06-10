import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/22
 */
public class lc293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < currentState.length(); ++i) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
                res.add(currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1));
            }
        }
        return res;
    }
}
