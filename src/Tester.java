public class Tester {
    public static void main(String[] args) {
        String s = "This sentence should output 5 words.";
        String [] a = s.split(" ");
        System.out.println(a.length);
        int i = 0;
        while(i < a.length){
            System.out.println(a[i]+"| e");
            i++;
        }
    }
}

