/**
 * Created by mingook on 2016년6월 21일 (화).
 */
public class Excercise7_14 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i] + ",");
        }
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
    }

    private static class SutdaCard {
        final int num;
        final boolean isKwang;

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
