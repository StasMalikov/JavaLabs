package logic;

public class Shellsort {

    public int[] sort(int arr[]) {
        long m = System.currentTimeMillis();

        int  d = arr.length / 2;
        while (d > 0)
        {
            for (int i = 0; i < arr.length - d; i++)
            {
                int j = i;
                while ( j >= 0 && arr[j] > arr[j + d])
                {
                    int count = arr[j];
                    arr[j] = arr[j + d];
                    arr[j + d] = count;
                    j--;
                }
            }
            d /= 2;
        }
        System.out.print((double) (System.currentTimeMillis() - m));
        System.out.print(" милисекунд отработала однопоточная сортировка\n");

        return arr;
    }
}
