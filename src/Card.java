public class Card {

    private CardValue value;
    private CardColor color;

    private enum CardValue{
        None(""), Deux("2"), Trois("3"), Quatre("4"), Cinq("5"), Six("6"), Sept("7"), Huit("8"), Neuf("9"), Dix("10"),
        Valet("V"), Dame("D"), Roi("R"), As("A");

        private String val;

        CardValue(String s){
            this.val = s;
        }

        public String getVal(){
            return this.val;
        }

        public static CardValue fromString(String s){
            for(CardValue val_card : CardValue.values()){
                if(s.equals(val_card.getVal())){
                    return val_card;
                }
            }
            return CardValue.None;
        }

    }

    private enum CardColor{
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


