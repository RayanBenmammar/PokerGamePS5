import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class HandReader {

    List<Card> usedCards;
    boolean valid;
    HandReader(){
        this.usedCards = new ArrayList<>();
        this.valid = true;
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
            Card card = new Card(str);
            for(int j =0; j< this.usedCards.size();j++){
                if( card.getColor() == this.usedCards.get(j).getColor() && card.getValue() == this.usedCards.get(j).getValue()){
                    this.valid = false;
                }
            }
            this.usedCards.add(new Card(str));
            list.add(new Card(str));
        }
        return new Hand(list);
    }

    public boolean isValid(){
        return this.valid;
    }

    // Renvoi l'index de la main qui gagne
    public int checkWinner(Hand hand1, Hand hand2) throws PokerException{
        hand1.checkCombinaison();
        hand2.checkCombinaison();
        int result = hand1.compareTo(hand2);
        if (result > 0) {
            return 0;
        } else if(result < 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
