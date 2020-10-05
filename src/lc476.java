/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/6
 */
public class lc476 {
    public int bitwiseComplement(int N) {
        String str = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0') sb.append('1');
            else sb.append('0');
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
