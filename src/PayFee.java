public class PayFee {
    public static void main(String[] args) {
        System.out.println("Provide the payment amount: ");
        double cost = IO.readDouble();
        double temp=cost;
        double fee = 0;
        if (cost<=0)
            return;
        if(cost<=500)
            fee = 10;
        else if (cost >500 && cost <5000) {
            temp *= .01;
            if (temp < 20)
                fee = 20;
            else
                fee=temp;
        }
        else if (cost >=5000 && cost <10000){
            temp *= .02;
            if(temp > 120)
                fee=temp;
            else
                fee=120;
        }
        else{
            double tempFinal= cost;
            fee+=10000*.02;
            System.out.println(fee);
            tempFinal-=10000;
            if(tempFinal>0) {
                fee+=5000*.03;
                System.out.println(fee);
                tempFinal-= 5000;
            }
            if(tempFinal>0)
                fee+=tempFinal*.04;
            System.out.println(fee);

        }
        IO.outputDoubleAnswer(fee);

    }
}

