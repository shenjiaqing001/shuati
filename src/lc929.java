import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/27
 */
public class lc929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            normalized.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return normalized.size();
    }
}
