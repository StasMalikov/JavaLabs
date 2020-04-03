package logic;

public class MyTread extends Thread {
    private CommonData data;

    public MyTread(CommonData data) {
        super();
        this.data = data;
    }

    public void run(){

        for (int _data[] = data.getData(); _data != null; _data = data.getData()) {
            int j = _data[0];
            while (j >= 0 && data.compareAndSwap(j, _data[1])) {
                j--;
            }
        }
    }
}
