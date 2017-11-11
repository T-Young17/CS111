public class PigLatin {
    public static void main(String[] args) {
    String s = IO.readString();
        System.out.println(translate(s));

    }
    public static String translate (String s){
        if(s.substring(0,1).equals("a")||s.substring(0,1).equals("e")||s.substring(0,1).equals("i")||s.substring(0,1).equals("o")||s.substring(0,1).equals("u")
                ||s.substring(0,1).equals("A")||s.substring(0,1).equals("E")||s.substring(0,1).equals("I")||s.substring(0,1).equals("O")||s.substring(0,1).equals("U"))
            s += "vai";
        else{
            String temp = s.substring(1)+ s.substring(0,1)+ "ai";
            s = temp;
        }


        return s;
    }

}
