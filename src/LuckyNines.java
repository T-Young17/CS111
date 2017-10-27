public class LuckyNines {
    public static void main(String[] args) {
        int lowerEnd = IO.readInt();
        int upperEnd = IO.readInt();
        IO.outputIntAnswer(countLuckyNines(lowerEnd, upperEnd));

}
    public static int countLuckyNines(int lowerEnd, int upperEnd){
        int count = 0;
        if (lowerEnd > upperEnd || upperEnd > lowerEnd){
            IO.reportBadInput();
            return -1;}
        for (int i = lowerEnd; i < upperEnd + 1; i++) {
            String s = Integer.toString(i);
            if (s.indexOf("9") != -1)
                count++;

        }
        return count;

    }
}