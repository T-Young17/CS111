public class TwoLargest {
    public static void main(String[] args) {


            int counter = 0;


            System.out.print("Enter terminating number: ");
            double term = IO.readDouble();
            counter++;

            System.out.print("Enter next number: ");
            double end = IO.readDouble();
            double max1, max2;
            if(end!=term){
                max1 = end;
                max2 = end;
                counter++;
            }
            else{
                do{
                    IO.reportBadInput();
                    end = IO.readDouble();
                }
                while(end==term);
                max1 = end;
                max2 = end;
                counter++;
            }

            end = IO.readDouble();

            if(end==term){
                //yes that's a do-while loop
                do{
                    IO.reportBadInput();
                    end = IO.readDouble();
                }
                while(end==term);
                counter++;
            }
            else
                counter++;

            if(end > max1){
                double temp = max1;
                max1 = end;
                max2 = temp;
            }
            else
                max2 = end;

            if(counter == 3){
                end = IO.readDouble();
                while(end != term){
                    if(end > max1){
                        double temp = max1;
                        max1 = end;
                        max2 = temp;
                    }
                    else{
                        if(end > max2)
                            max2 = end;
                    }
                    end = IO.readDouble();
                }
            }

            IO.outputDoubleAnswer(max1);
            IO.outputDoubleAnswer(max2);

        }


    }