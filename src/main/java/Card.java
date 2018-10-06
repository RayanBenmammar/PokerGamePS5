public class Card {

    private CardValue value;
    private CardColor color;

     enum CardValue{
        None("",0), Deux("2",2), Trois("3",3), Quatre("4",4), Cinq("5",5), Six("6",6), Sept("7",7), Huit("8",8), Neuf("9",9), Dix("10",10),
        Valet("V",11), Dame("D",12), Roi("R",13), As("A",14), ;

        private String val;
        private int value;

        CardValue(String s, int value){
            this.val = s;
            this.value = value;
        }

        public String getVal(){
            return this.val;
        }

        public int getIntVal(){ return this.value;}

        public static CardValue fromString(String s){
            for(CardValue val_card : CardValue.values()){
                if(s.equals(val_card.getVal())){
                    return val_card;
                }
            }
            return CardValue.None;
        }

    }

     enum CardColor{
        None(""), Pique("Pi"), Trefle("Tr"), Carreau("Ca"), Coeur("Co");

        private String coul;

        CardColor(String s) { this.coul = s;}

        public String getCol() {return this.coul;}

        public static CardColor fromString(String s){
            for(CardColor card_color : CardColor.values()){
                if(s.equals(card_color.getCol())){
                    return card_color;
                }
            }
            return CardColor.None;
        }
    }

    Card(){
         this.value = CardValue.None;
         this.color = CardColor.None;
    }

    Card(String card){
        this.value = CardValue.fromString(card.substring(0,card.length() - 2));
        this.color = CardColor.fromString(card.substring(card.length() - 2));
    }

    boolean isWeakerThan(Card c){
        return this.getValue().compareTo(c.getValue()) < 0;
    }

    boolean isSameColor(Card c) { return this.getColor().equals(c.getColor());}

    boolean equals(Card c) { return this.getValue().equals(c.getValue()); }

    public CardColor getColor() {
        return this.color;
    }

    public CardValue getValue() {
        return this.value;
    }

}


