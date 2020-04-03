package logic;

public class CommonData {
    private int arr[];
    private int d;
    private int i;

    public CommonData(int arr[]) {
        this.arr = arr;
        i = 0;
        d = arr.length / 2;
    }

    public synchronized int[] getData() {
        if (d > 0) {
            if (i < arr.length - d) {
                return new int[]{i++, d};
            } else {
                i = 0;
                d /= 2;
                return new int[]{i++, d};
            }
        } else {
            return null;
        }
    }

    public synchronized boolean compareAndSwap(int j, int d) {
        if (arr[j] > arr[j + d]) {
            int count = arr[j];
            arr[j] = arr[j + d];
            arr[j + d] = count;
            return true;
        } else {
            return false;
        }
    }

    public int[] getArr() {
        return arr;
    }
}
