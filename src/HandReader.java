import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class HandReader {
    HandReader(){

    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public Hand readCardsFromInput(int cardNumber, int index){
        System.out.println("Veuillez entrer la main " + (index+1) +", avec la bonne forme : ");
        Scanner sc = new Scanner(System.in);
        List<Card> list = new ArrayList<>();

        for(int i = 0; i<cardNumber; i++){
            String str = sc.next();
            list.add(new Card(str));
        }
        return new Hand(list);
    }

    public int checkWinner(Hand hand1, Hand hand2) throws PokerException{
        hand1.checkCombinaison();
        hand2.checkCombinaison();
        if (hand1.isWeakerThan(hand2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
