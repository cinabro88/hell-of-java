/**
 * Created by mingook on 2016년7월 3일 (일).
 */
public class Exercise13_7 {
    public static boolean stopped = false;

    public static void main(String[] args) {
        Thread7 t = new Thread7();
        t.start();

        try {
            Thread.sleep(6 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopped = true;
        t.interrupt();
        System.out.println("stopped");
    }
}

class Thread7 extends Thread {
    @Override
    public void run() {
        for (int i = 0; !Exercise13_7.stopped; i++) {
            System.out.println(i);
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
