public class LuckyNines {
    public static void main(String[] args) {
            System.out.print("Enter lower bound: " );
            int lower = IO.readInt();

            System.out.print("Enter higher bound: ");
            int higher = IO.readInt();

            IO.outputDoubleAnswer(countLuckyNines(lower,higher));
        }


    public static int countLuckyNines(int lowerEnd, int upperEnd) {
        int count = 0;
        if(lowerEnd > upperEnd || upperEnd < lowerEnd) {
            IO.reportBadInput();
            return -1;
        }
        for(int i = lowerEnd; i <= upperEnd; i ++) {
            int term = Math.abs(i);


            while(term > 0) {
                if(term % 10 == 9) {
                    count ++;
                }

                term /= 10;
            }
        }

        return count;
    }

}