public class WordCount {
    public static void main(String[] args) {

        String s = "This sentence should output 5 words";
        System.out.println(countWords(s, 8));


    }

    public static int countWords(String s, int maxLength) {
        //ignores punctuation and white space denotes end of a word
        int wordCount = 0;
        int numChar = 0;

        String[] a = s.split(" ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                if (Character.isLetter(a[i].charAt(j)))
                    numChar++;
            }
            if (numChar <= maxLength && numChar != 0)
                wordCount++;
            numChar = 0;
        }
        return wordCount;
    }
}
