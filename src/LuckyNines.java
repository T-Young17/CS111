public class LuckyNines {
    public static void main(String[] args) {
        int a = IO.readInt();
        int b = IO.readInt();
        System.out.println(countLuckyNines(a,b));
    }
    public static int countLuckyNines( int lowerEnd, int upperEnd){
        int count = 0;
        int starter = 0;
        if (upperEnd<lowerEnd||upperEnd<0&&lowerEnd>0)
            return -1;
        for (int i = lowerEnd; i<=upperEnd+1; i++){
            if (i == upperEnd+1)
                return -1;
            if (i%10==9){
                starter = i;
                break;
            }
        }
        for(int i = starter; i<upperEnd; i+=10)
            count++;
        return count;
    }
}
