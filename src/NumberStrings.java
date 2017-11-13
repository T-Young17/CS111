public class NumberStrings {
    public static void main(String[] args) {
        String[][] a = new String[5][10];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j % 2 == 0)
                    a[i][j] = "a";
                else
                    a[i][j]="b";
            }
        }
        System.out.println(a[1]);
        System.out.println(search(a,"a"));
    }

    public static int search(String[][] arr, String s) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(s))
                    count++;
            }
        }
        return count;
    }
}
