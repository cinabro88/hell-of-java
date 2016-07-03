import javax.swing.*;

/**
 * Created by mingook on 2016년7월 3일 (일).
 */
public class Exercise13_9 {
    public static void main(String[] args) {
        InputMonitor monitor = new InputMonitor();
        monitor.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + " 입니다.");
        monitor.interrupt();
    }
}

class InputMonitor extends Thread {
    @Override
    public void run() {
        int i = 10;
        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }

        System.out.println("모니터 종료.");
    }
}
