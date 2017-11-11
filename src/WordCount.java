public class WordCount {
    public static void main(String[] args) {
        String s = "This sentence should output 5 words";
        System.out.println(countWords(s,1));

    }
    public static int countWords(String s, int maxLength){
        //ignores punctuation and white space denotes end of a word
        int wordCount =0;
        int counter = 0;
        for(int i =0; i< s.length(); i++){
            if (Character.isLetter(s.charAt(i)) && s.charAt(i)!= '0' ||s.charAt(i)!= '1' ||s.charAt(i)!= '2' ||s.charAt(i)!= '3' ||s.charAt(i)!= '4' ||s.charAt(i)!= '5' ||s.charAt(i)!= '6' ||s.charAt(i)!= '7' ||
                    s.charAt(i)!= '8' ||s.charAt(i)!= '9')
                counter ++;



            if(s.charAt(i)==' ' && counter <= maxLength){
                wordCount++;
                counter =0;
            }
            else if( s.charAt(i)==' ' && counter > maxLength)
                counter = 0;
        }
      /* String [] a = s.split(" ");
       for(int i = 0; i< a.length; i++){
        for (int j = 0; j<a[i].length(); j++) {
           if (Character.isLetter(a[i].charAt(j)))
               counter++;
           if(counter > maxLength)
               break;
           if (counter <= maxLength && j == a[i].length()-1)
               wordCount++;

       }
       counter = 0;
       }*/
       return wordCount;
    }
}
