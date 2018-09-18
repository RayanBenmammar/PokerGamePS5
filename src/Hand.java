import java.util.List;

public class Hand {

    public List<Card> hand;

    Hand(List<Card> new_hand){
        hand = new_hand;
    }

    public boolean isWeakerThan(Hand hand1){
        return this.hand.get(0).isWeakerThan(hand1.hand.get(0));
    }

}
