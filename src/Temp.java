public class Temp {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long helper = 1;
        for (int i = 0; i < 28; i++) {
            helper *= 2;
        }
        for (int k = 0; k < 4000; k++) {
            for (int i = 0; i < 4; i++) {
                sb.append(((int)(Math.random() * helper * 2)) - helper).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
