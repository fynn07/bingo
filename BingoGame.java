import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoGame implements Runnable{
    List<BingoCard> cards;
    static boolean[] result;
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();
        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i+1));
        }
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }
        // TODO create your checker threads per card
        Thread[] checkerThrds = new Thread[cnt];
        for (int i = 0; i < cnt; i++) {
            checkerThrds[i] = new Thread(new BingoRowChecker(cards.get(i), 3));
        }
        // TODO start all threads

        // TODO RANDOM RESULTS
        // TODO randomly get number from 1-75 while not bingo
    }
}