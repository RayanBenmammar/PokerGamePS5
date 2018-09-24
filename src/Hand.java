import java.util.List;
import java.util.ArrayList;

public class Hand {

    public List<Card> hand;
    public Combination bestCombination;

    public enum Combination{
        None(""), Paire("Paire"), DoublePaire("Double Paire"), Brelan("Brelan"), Carre("Carré"), Full("Full"),
        Suite("Suite"), Couleur("Couleur"), QuinteFlush("Quinte Flush");

        private String val;
        private Card combin_card;

        Combination(String s){
            this.val = s;
        }

        public String getVal(){
            return this.val;
        }

        public Card getCombiCard() { return this.combin_card; }
        public void setCombiCard(Card card_) { this.combin_card = card_; }

        public static Combination fromString(String s){
            for(Combination val_card : Combination.values()){
                if(s.equals(val_card.getVal())){
                    return val_card;
                }
            }
            return Combination.None;
        }
    }

    Hand(List<Card> new_hand){
        this.hand = new_hand;
    }

    public void checkCombinaison(){
        this.pair();
    }

    public Combination getBestCombi(){
        return this.bestCombination;
    }

    public boolean isWeakerThan(Hand hand1){
        return this.bestCombination.compareTo(hand1.bestCombination) < 0;
    }

    public Card getCardFromHand(int index){
        return hand.get(index);
    }

    public boolean hasSameCombination(Hand hand1){
        return this.getBestCombi().equals(hand1.getBestCombi());
    }

    public boolean pair(){
        for(int i = 0 ; i < this.hand.size() ; i++){
            for(int j = this.hand.size()-1 ; j > i ; j--){
                if(this.getCardFromHand(i).getValue() == this.getCardFromHand(j).getValue()){
                    this.bestCombination = Combination.Paire;
                    this.bestCombination.setCombiCard(this.getCardFromHand(j));
                    return true;
                }
            }
        }
        return false;
    }
}
