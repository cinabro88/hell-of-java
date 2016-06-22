import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mingook on 2016년6월 21일 (화).
 */
public class Excercise7_2 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (SutdaCard card : deck.cards) {
            System.out.print(card + ",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }

    private static class SutdaDeck {
        final int CARD_NUM = 20;
        public SutdaCard[] cards;

        public SutdaDeck() {
            cards = new SutdaCard[CARD_NUM];
            for (int i = 0; i < CARD_NUM; i++) {
                boolean isKwang = (i == 0 || i == 2 || i == 7);
                cards[i] = new SutdaCard(i % 10 + 1, isKwang);
            }
        }

        public void shuffle() {
            List<SutdaCard> temp = new ArrayList<>(Arrays.asList(cards));
            for (int i = 0; i < CARD_NUM; i++) {
                int randomIndex = (int) (Math.random() * (temp.size() - 1));
                cards[i] = temp.remove(randomIndex);
            }
        }

        public SutdaCard pick(int index) {
            return cards[index];
        }

        public SutdaCard pick() {
            int index = (int) (Math.random() * CARD_NUM - 1);
            return cards[index];
        }
    }

    private static class SutdaCard {
        int num;
        boolean isKwang;

        public SutdaCard() {
            this(1, true);
        }

        public SutdaCard(int num, boolean isKwang) {
            this.num = num;
            this.isKwang = isKwang;
        }

        @Override
        public String toString() {
            return num + (isKwang ? "K" : "");
        }
    }
}
