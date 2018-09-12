public class Carte {

    private ValeurCarte valeur;
    private String couleur;

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

    Carte(String carte){
        this.valeur = ValeurCarte.fromString(carte.substring(0,carte.length() - 2));
        this.couleur = carte.substring(carte.length() - 2);
    }

    boolean isWeakerThan(Carte c){
        return this.getValeur().compareTo(c.getValeur()) < 0;
    }

    public String getCouleur() {
        return this.couleur;
    }

    ValeurCarte getValeur() {
        return this.valeur;
    }

}


