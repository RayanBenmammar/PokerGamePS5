import java.util.List;
import java.util.ArrayList;

public class Hand {

    public List<Card> hand;

    Hand(List<Card> new_hand){
        this.hand = new_hand;
    }

    public boolean isWeakerThan(Hand hand1){
        return this.hand.get(0).isWeakerThan(hand1.hand.get(0));
    }

    public Card getCardFromHand(int index){
        return hand.get(index);
    }

    public boolean equals(Hand hand1){
        return this.getCardFromHand(0).equals(hand1.getCardFromHand(0));
    }

    public boolean pair(){
        for(int i = 0 ; i < this.hand.size() ; i++){
            for(int j = this.hand.size()-1 ; j > i ; j--){
                if(this.hand.get(i).getValue() == this.hand.get(j).getValue()){
                    return true;
                }
            }
        }
        return false;
    }
}
