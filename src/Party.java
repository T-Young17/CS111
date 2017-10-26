
 
public class Party {
    public static void main(String[] args) {
        System.out.println("please input the number of people attending the party, the number of slices each person will eat, the number of cans of soda each person will drink, the cost of each pie of pizza" +
                "the number of slices in a pie, the cost of each case of soda and the number of cans in each case of soda: in that order: ");
        int people = IO.readInt();
        int slices = IO.readInt();
        int totalSlices=people*slices;
        int cans = IO.readInt();

        double costP = IO.readDouble();
        double perPie = IO.readInt();
        double finalPies = Math.ceil(totalSlices/perPie)*costP;

        double costC = IO.readDouble();
        double perCase=IO.readInt();
        int totalCans= (people*cans);
        double extraCans=totalCans%perCase;
        double finalCans = costC*Math.ceil(totalCans/perCase);

        IO.outputDoubleAnswer(finalCans+finalPies);
        //I was overthinking this too hard lol
    }
}
