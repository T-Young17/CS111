public class NumberDuplicates {
    public static void main(String[] args) {
        System.out.println(countDuplicates("Clifford the big red dog"));
    }

    public static String countDuplicates(String s) {
        String[] a = new String[s.length() - 1];
        String alpha = "qwertyuiopasdfghjklzxcvbnm";
        String temp = "";
        int count = 0;
        char l = ' ';
        for (int i = 0; i < alpha.length(); i++) {
            l = alpha.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)==l)
                    count++;
            }
            if (count > 1)
                temp += Integer.toString(count) + Character.toString(l);
            count = 0;
        }
        return temp;
    }
}
