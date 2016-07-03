import java.util.Scanner;
import java.util.Vector;

/**
 * Created by mingook on 2016년7월 3일 (일).
 */
public class Exercise13_8 {
    static Vector words = new Vector();
    static String[] data = {"소나기", "우아한형제들", "배달의민족", "지옥자바", "개발자", "배민프레시"};

    static int interval = 2 * 1000;

    WordGenerator wordGenerator = new WordGenerator();

    public static void main(String[] args) {
        Exercise13_8 game = new Exercise13_8();
        game.wordGenerator.start();

        Vector words = game.words;

        while (true) {
            System.out.println(words);

            String prompt = ">>";
            System.out.print(prompt);

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();

            int index = words.indexOf(input);

            if (index != -1) {
                words.remove(index);
            }
        }
    }
}

class WordGenerator extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(Exercise13_8.interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int randomIndex = (int) (Math.random() * (Exercise13_8.data.length - 1));
            Exercise13_8.words.add(Exercise13_8.data[randomIndex]);

        }
    }
}