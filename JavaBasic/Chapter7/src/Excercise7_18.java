/**
 * Created by mingook on 2016년6월 22일 (수).
 */
public class Excercise7_18 {

    public static void main(String[] args) {
        Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
        for (Robot robot : arr) {
            action(robot);
        }
    }

    public static void action(Robot robot) {
        if (robot instanceof DanceRobot) {
            ((DanceRobot) robot).dance();
        } else if (robot instanceof SingRobot) {
            ((SingRobot) robot).sing();
        } else if (robot instanceof DrawRobot) {
            ((DrawRobot) robot).draw();
        }
    }

    static class Robot {
    }

    static class DanceRobot extends Robot {
        void dance() {
            System.out.println("DanceRobot.dance");
        }
    }

    static class SingRobot extends Robot {
        void sing() {
            System.out.println("SingRobot.sing");
        }
    }

    static class DrawRobot extends Robot {
        void draw() {
            System.out.println("DrawRobot.draw");
        }
    }
}
