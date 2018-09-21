import java.util.List;
import java.util.ArrayList;

public class Hand {

    public List<Card> hand;
    public Combination bestCombination;

    private enum Combination{
        None(""), Paire("Paire"), DoublePaire("Double Paire"), Brelan("Brelan"), Carre("Carré"), Full("Full"),
        Suite("Suite"), Couleur("Couleur"), QuinteFlush("Quinte Flush");

        private String val;

        Combination(String s){
            this.val = s;
        }

        public String getVal(){
            return this.val;
        }

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
                    this.bestCombination = Combination.Paire;
                    return true;
                }
            }
        }
        return false;
    }
}
