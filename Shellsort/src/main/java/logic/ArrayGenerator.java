package logic;

public class ArrayGenerator {

    private static final int MAXNUMBERINARR = 1000;

    public int[] genereteArr(int size) {
        int arr[] = new int[size];
        for(int i=0; i< size; i++) {
            arr[i] = (int)(Math.random()*MAXNUMBERINARR);
        }
        return arr;
    }

}
