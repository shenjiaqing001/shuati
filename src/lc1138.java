/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/12
 */
public class lc1138 {
    public static void main(String[] args) {

        System.out.println((-1) / 5);
    }

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char now = 'a';
        // 5 * 5 + 1
        for (char c : target.toCharArray()) {
            int pc = c - 'a';
            int pnow = now - 'a';
            int pcx = pc / 5;
            int pcy = pc % 5;
            int pnowx = pnow / 5;
            int pnowy = pnow % 5;
            if (c == 'z') {
                while (pnowy < pcy) {
                    sb.append("R");
                    pnowy++;
                }
                while (pnowy > pcy) {
                    sb.append("L");
                    pnowy--;
                }
                while (pnowx < pcx) {
                    sb.append("D");
                    pnowx++;
                }
                while (pnowx > pcx) {
                    sb.append("U");
                    pnowx--;
                }
            } else {
                while (pnowx < pcx) {
                    sb.append("D");
                    pnowx++;
                }
                while (pnowx > pcx) {
                    sb.append("U");
                    pnowx--;
                }
                while (pnowy < pcy) {
                    sb.append("R");
                    pnowy++;
                }
                while (pnowy > pcy) {
                    sb.append("L");
                    pnowy--;
                }
            }

            sb.append("!");
            now = c;
        }
        return sb.toString();
    }
}
