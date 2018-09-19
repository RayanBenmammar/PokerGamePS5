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


}