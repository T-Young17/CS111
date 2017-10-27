public class SmallestLargest {
    public static void main(String[] args) {
        double smallest = 0;
        double largest=0;
        double first=0;
        double end;
        int count=0;
        System.out.println("input the exact same number as the first one to signal a termination of the sequence:");
        end = IO.readDouble();
        System.out.println("input first term");
        first = IO.readDouble();
        if (first == end){
            IO.reportBadInput();
            return;}
        largest = first;
        smallest = first;
        while(true){
            double a = IO.readDouble();

            if(a == end)
                break;

            if( a > largest)
                largest = a;
            else if( a < smallest)
                smallest = a;
            count++;
        }
        if(count<2)
            IO.reportBadInput();

        IO.outputDoubleAnswer(smallest);
        IO.outputDoubleAnswer(largest);
    }

}
