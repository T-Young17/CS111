public class LuckySevens {
    public static void main(String[] args) {
        int lowerEnd = IO.readInt();
        int upperEnd = IO.readInt();
        int count = 0;
        if (lowerEnd > upperEnd)
            IO.reportBadInput();
        for (int i = lowerEnd; i < upperEnd + 1; i++) {
            String s = Integer.toString(i);
            if (s.indexOf("7") != -1)
                count++;

        }
        IO.outputIntAnswer(count);
    }
}

