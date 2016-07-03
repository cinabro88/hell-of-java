/**
 * Created by mingook on 2016년7월 3일 (일).
 */
public class Exercise13_5 {
    public static void main(String[] args) throws Exception {
        Thread5 th = new Thread5();
        th.start();

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new Exception(("꽝~~"));
    }

}

class Thread5 extends Thread {
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
