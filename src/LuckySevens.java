public class LuckySevens {
    public static void main(String[] args) {
        int count = 0;
        System.out.print("Enter lower bound: ");
        int lower = IO.readInt();

        System.out.print("Enter upper bound: ");
        int upper = IO.readInt();

        if(lower > upper || upper < lower) {
            IO.reportBadInput();
        }

        for(int i = lower; i <= upper; i++) {
            int term = Math.abs(i);
            while(term > 0) {
                if(term % 10 == 7) {
                    count ++;
                }

                term /= 10;
            }
        }

        IO.outputIntAnswer(count);
    }

}
