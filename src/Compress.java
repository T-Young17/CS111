public class Compress {
    public static void main(String[] args) {
    String s = "abcdasdasdsaddadasdefs";
        System.out.println(compress(s));

    }
    public static String compress (String s){
        String temp="";
        int count = 0;
        String l= "";
        if(s.equals(null)||s.equals(""))
            return null;

        for (int i =0; i < s.length(); i++) {

            if (i == 0 || l.charAt(0) != s.charAt(i)) {
                if (count > 1)
                    temp += Integer.toString(count) + l;
                else if (count == 1)
                    temp += l;
                l = s.substring(i, i + 1);
                count = 0;
            } else if (i == 0)
                l = s.substring(0, 1);

            if (s.substring(i, i + 1).equals(l))
                count++;
            if (i == s.length() - 1)
                temp += Integer.toString(count) + l;
        }
            return temp;
    }}


