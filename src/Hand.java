import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {

    public List<Card> hand;
    public Combination bestCombination;
    public Card.CardValue bestCombinationValue;
    private HashMap<Card.CardValue, Integer> occurenceCount ;

    protected enum Combination{
        None("Une hauteur",0), Paire("Paire",1), DoublePaire("Double Paire",2), Brelan("Brelan",3), Carre("Carré",4), Full("Full",5),
        Suite("Suite",6), Couleur("Couleur",7), QuinteFlush("Quinte Flush",8);

        private String val;
        private Card combin_card;
        private int point;

        Combination(String s, int value){
            this.val = s;
            this.point = value;
        }

        public String getVal(){
            return this.val;
        }

        public Card getCombiCard() { return this.combin_card; }

        public void setCombiCard(Card card_) { this.combin_card = card_; }

        public int getPoint(){
            return  this.point;
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
        this.Occurences();

    }

    private void Occurences(){
        occurenceCount =  new HashMap<Card.CardValue, Integer>();
        for( Card c : this.hand){
            if(occurenceCount.containsKey(c.getValue())){
                occurenceCount.put(c.getValue(), occurenceCount.get(c.getValue())+1);
            }
            else{
                occurenceCount.put(c.getValue(),1);
            }
        }
        /*for(Map.Entry entry : occurenceCount.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

    }

    public void checkCombinaison(){
        this.pair();
        this.brelan();
        if(!this.pair() && !this.brelan()){
            this.bestCombination = Combination.None;
            this.bestCombinationValue =  Card.CardValue.None;
            for( Card c : this.hand){
                if(Integer.parseInt( (c.getValue().getVal())) > Integer.parseInt(this.bestCombinationValue.getVal())){
                    this.bestCombinationValue = c.getValue();
                }
            }
        }
    }

    public Combination getBestCombi(){
        return this.bestCombination;
    }

    public boolean isWeakerThan(Hand hand1) {
        return Integer.valueOf(this.bestCombination.getPoint()).compareTo(hand1.bestCombination.getPoint()) < 0;
    }

    public Card.CardValue getBestCombinationValue(){
        return this.bestCombinationValue;
    }

    public int getPointCombi(){
        return  this.bestCombination.getPoint();
    }


    public void high(){

        for( Card c : this.hand){
            if(Integer.parseInt( (c.getValue().getVal())) > Integer.parseInt(this.bestCombinationValue.getVal())){
                this.bestCombinationValue = c.getValue();
            }
        }
        this.bestCombination = Combination.None;

    }


    public Card getCardFromHand(Card.CardValue index){
         Card card = new Card("empty");
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getValue() == index) card = hand.get(i);
        }

        return card;
    }

    public boolean hasSameCombination(Hand hand1){
        return this.getBestCombi().equals(hand1.getBestCombi());
    }



   public boolean pair(){
        for( Map.Entry entry :  this.occurenceCount.entrySet()){
            if(entry.getValue() == Integer.valueOf(2) ) {
                this.bestCombination = Combination.Paire;
                this.bestCombination.setCombiCard(this.getCardFromHand((Card.CardValue) entry.getKey()));
                this.bestCombinationValue = (Card.CardValue) entry.getKey();

                return true;}

        }
        return false;

    }

    public boolean brelan(){
        for( Map.Entry entry :  this.occurenceCount.entrySet()){
            if(entry.getValue() == Integer.valueOf(3) ) {
                this.bestCombination = Combination.Brelan;
                this.bestCombination.setCombiCard(this.getCardFromHand((Card.CardValue) entry.getKey()));
                this.bestCombinationValue = (Card.CardValue) entry.getKey();
                return true;}

        }
        return false;

    }
}
