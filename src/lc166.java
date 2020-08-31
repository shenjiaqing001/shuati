import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/15/20
 */
public class lc166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long nume = numerator;
        long deno = denominator;

        if (nume == 0) return String.valueOf(0);
        StringBuffer sb = new StringBuffer();
        if (nume < 0 && deno > 0 ||
                nume > 0 && deno < 0)
            sb.append('-');
        nume = Math.abs(nume);
        deno = Math.abs(deno);
        sb.append(nume / deno);
        nume %= deno;
        if (nume == 0) return sb.toString();
        sb.append('.');

        Map<Long, Integer> map = new HashMap<>();
        map.put(nume, sb.length());
        int count = 0;
        while (nume != 0) {
            nume *= 10;
            sb.append(nume / deno);
            nume %= deno;
            if (map.containsKey(nume)) {
                sb.insert(map.get(nume), "(");
                sb.append(')');
                break;
            }
            map.put(nume, sb.length());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        lc166 t = new lc166();
        System.out.println(t.fractionToDecimal(-1, -2147483648));
    }
}
