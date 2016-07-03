/**
 * Created by mingook on 2016년7월 3일 (일).
 */
public class Exercise13_6 {
    public static void main(String[] args) throws Exception {
        Thread6 th = new Thread6();
        th.setDaemon(true);
        th.start();

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new Exception(("꽝~~"));
    }

}

class Thread6 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
