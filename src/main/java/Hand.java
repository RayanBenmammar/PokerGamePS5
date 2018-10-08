import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Hand {

    public List<Card> hand;
    public Combination bestCombination;
    public Card bestCombinationCard;
    private HashMap<Card.CardValue, Integer> occurenceCount ;

    protected enum Combination{
        None("Une hauteur"), Paire("Paire"), DoublePaire("Double Paire"), Brelan("Brelan"), Suite("Suite"), Couleur("Couleur"),
        Full("Full"), Carre("Carré"), QuinteFlush("Quinte Flush");

        private String val;

        Combination(String s){
            this.val = s;
        }

        public String getVal(){
            return this.val;
        }

        public boolean isWeakerThan(Combination combin){
            return this.compareTo(combin) < 0;
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

    Hand(){
        this.bestCombination = Combination.None;
        this.bestCombinationCard = new Card();
        List<Card> list = new ArrayList<>();
        for(int i = 0; i<5; i++){
            list.add(new Card());
        }
        this.hand = list;
    }

    Hand(List<Card> new_hand){
        this.bestCombination = Combination.None;
        this.bestCombinationCard = new Card();
        this.hand = new_hand;
        this.Occurences();

    }

    public Card getCombiCard() { return this.bestCombinationCard; }

    public void setCombiCard(Card card_) { this.bestCombinationCard = card_; }

    private void Occurences(){
        occurenceCount =  new HashMap<>();
        for( Card c : this.hand){
            if(occurenceCount.containsKey(c.getValue())){
                occurenceCount.put(c.getValue(), occurenceCount.get(c.getValue())+1);
            }
            else{
                occurenceCount.put(c.getValue(),1);
            }
        }
    }

    public boolean areCardsValid(){
        for (Card aCard : this.hand) {
            if(aCard.getValue() == Card.CardValue.None || aCard.getColor() == Card.CardColor.None){
                return false;
            }
        }
        return true;
    }

    public void checkCombinaison() throws PokerException{
        try{
            this.pair();
            this.doublePaire();
            this.brelan();
            this.suite();
            this.couleur();
            this.full();
            this.carre();
            this.quinteFlush();
            if(this.bestCombination.equals(Combination.None)){
                this.high();
            }
            System.out.println("combi: " +this.bestCombination.getVal());
        } catch(Exception e){
            throw new PokerException("Erreur lors de la vérification des combinaisons.");
        }
    }

    public Combination getBestCombi(){
        return this.bestCombination;
    }

    public boolean isWeakerThan(Hand hand2) throws PokerException{
        try {
            // On vérifie si une main a une combinaison plus forte que l'autre
            if(this.bestCombination.isWeakerThan(hand2.bestCombination)){
                return true;
            } else if (hand2.bestCombination.isWeakerThan(this.bestCombination)){
                return false;
            }
        } catch(Exception e){
            throw new PokerException("Erreur lors de la comparaison des niveaux de combinaisons");
        }

        try{
            // Les deux mains ont la même combinaison, donc on vérifie la valeur de carte de leur combinaisons
            if(this.getCombiCard().isWeakerThan(hand2.getCombiCard())){
                return true;
            } else if(hand2.getCombiCard().isWeakerThan(this.getCombiCard())){
                return false;
            }
        } catch(Exception e){
            throw new PokerException("Erreur lors du calcul de hauteur entre les combinaisons.");
        }

        try{
            // Il y a les deux même combinaisons dans les deux mains, il faut donc faire la hauteur avec les cartes restantes
        } catch(Exception e){
            throw new PokerException("Erreur lors du calcul de hauteur entre les cartes qui ne sont pas dans une combinaison.");
        }




        return this.getCombiCard().isWeakerThan(hand2.getCombiCard());
    }

    public void high(){
        this.setCombiCard(hand.get(0));
        for( Card c : this.hand){
            if(!c.isWeakerThan(this.bestCombinationCard)){
                this.bestCombinationCard = c;
            }
        }

    }

    public Card getCardFromHand(Card.CardValue index){
        Card card = new Card();
        for (Card aCard : hand) {
            if (aCard.getValue() == index) card = aCard;
        }
        return card;
    }

    public boolean hasSameCombination(Hand hand2){
        return this.getBestCombi().equals(hand2.getBestCombi());
    }

   public boolean pair(){
        for( Map.Entry entry :  this.occurenceCount.entrySet()){
            if(entry.getValue() == Integer.valueOf(2) ) {
                this.bestCombination = Combination.Paire;
                this.setCombiCard(this.getCardFromHand((Card.CardValue) entry.getKey()));
                return true;
            }

        }
        return false;

    }

    public boolean brelan(){
        for( Map.Entry entry :  this.occurenceCount.entrySet()){
            if(entry.getValue() == Integer.valueOf(3) ) {
                this.bestCombination = Combination.Brelan;
                this.setCombiCard(this.getCardFromHand((Card.CardValue) entry.getKey()));
                return true;
            }

        }
        return false;

    }

    public boolean carre(){
        for( Map.Entry entry :  this.occurenceCount.entrySet()){
            if(entry.getValue() == Integer.valueOf(4) ) {
                this.bestCombination = Combination.Carre;
                this.setCombiCard(this.getCardFromHand((Card.CardValue) entry.getKey()));
                return true;
            }

        }
        return false;
    }

    public boolean doublePaire(){
         int cnt = 0;
         Card.CardValue card1 = Card.CardValue.None;
        for( Map.Entry entry :  this.occurenceCount.entrySet()){
            if(entry.getValue() == Integer.valueOf(2) ) {
                cnt++;
                if(((Card.CardValue)entry.getKey()).compareTo(card1) >0 ){
                    card1 = (Card.CardValue) entry.getKey();
                }

            }

            if(cnt == 2){
                this.bestCombination = Combination.DoublePaire;
                this.setCombiCard(this.getCardFromHand(card1));
                return true;}

        }
        return false;
    }

    public boolean full(){
            if( occurenceCount.containsValue(Integer.valueOf(3)) && occurenceCount.containsValue(Integer.valueOf(2)) ) {
                this.bestCombination = Combination.Full;
                for( Map.Entry entry :  this.occurenceCount.entrySet()){
                    if(entry.getValue() == Integer.valueOf(3) ) {
                        this.setCombiCard(this.getCardFromHand((Card.CardValue) entry.getKey()));
                        return true;
                    }
                }

            }
        return false;

    }

    public boolean suite(){
        Card.CardValue min= this.hand.get(0).getValue();
        Card.CardValue max= this.hand.get(0).getValue();

        for (Card aCard : this.hand) {
            if (aCard.getValue().compareTo(min) < 0) min = aCard.getValue();
            if (aCard.getValue().compareTo(max) > 0) max = aCard.getValue();
        }

        int sum = min.getIntVal()+4;

       /* if(!this.pair() && !this.brelan() && !this.carre() && ( sum == max.getIntVal())) {*/
        if(!this.occurenceCount.containsValue(2) && !this.occurenceCount.containsValue(3) && !this.occurenceCount.containsValue(4)&&( sum == max.getIntVal())) {
            this.bestCombination = Combination.Suite;
            this.setCombiCard(this.getCardFromHand(max));
            return true;}

        return false;

    }

    public boolean couleur(){

        Card.CardColor ref = this.hand.get(0).getColor();
        Card.CardValue max= this.hand.get(0).getValue();

        for (Card aCard : this.hand) {
            if(aCard.getValue().compareTo(max) >0 ) max= aCard.getValue();
            if (aCard.getColor() != ref) return false;
        }

        this.bestCombination = Combination.Couleur;
        this.setCombiCard(this.getCardFromHand(max));
        return true ;
    }

    public boolean quinteFlush(){
        if( this.suite() && this.couleur()) {
            this.bestCombination = Combination.QuinteFlush;
            return true;
        }

        return false;
    }

}
