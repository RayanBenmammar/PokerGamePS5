public class Carte {

    private ValeurCarte valeur;
    private CouleurCarte couleur;

    private enum ValeurCarte{
        None(""), Deux("2"), Trois("3"), Quatre("4"), Cinq("5"), Six("6"), Sept("7"), Huit("8"), Neuf("9"), Dix("10"),
        Valet("V"), Dame("D"), Roi("R"), As("A");

        private String val;

        ValeurCarte(String s){
            this.val = s;
        }

        public String getVal(){
            return this.val;
        }

        public static ValeurCarte fromString(String s){
            for(ValeurCarte val_carte : ValeurCarte.values()){
                if(s.equals(val_carte.getVal())){
                    return val_carte;
                }
            }
            return ValeurCarte.None;
        }

    }

    private enum CouleurCarte{
        None(""), Pique("Pi"), Trefle("Tr"), Carreau("Ca"), Coeur("Co");

        private String coul;

        CouleurCarte(String s) { this.coul = s;}

        public String getCoul() {return this.coul;}

        public static CouleurCarte fromString(String s){
            for(CouleurCarte coul_carte : CouleurCarte.values()){
                if(s.equals(coul_carte.getCoul())){
                    return coul_carte;
                }
            }
            return CouleurCarte.None;
        }
    }

    Carte(String carte){
        this.valeur = ValeurCarte.fromString(carte.substring(0,carte.length() - 2));
        this.couleur = CouleurCarte.fromString(carte.substring(carte.length() - 2));
    }

    boolean isWeakerThan(Carte c){
        return this.getValeur().compareTo(c.getValeur()) < 0;
    }

    boolean isSameColor(Carte c) { return this.getCouleur().equals(c.getCouleur());}

    boolean equals(Carte c) { return this.getValeur().equals(c.getValeur()); }

    public CouleurCarte getCouleur() {
        return this.couleur;
    }

    ValeurCarte getValeur() {
        return this.valeur;
    }

}


