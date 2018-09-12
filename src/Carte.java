public class Carte {

    private int valeur;
    private String couleur;

    public Carte(String carte){
        this.valeur = Integer.parseInt(carte.substring(0,carte.length() - 2));
        this.couleur = carte.substring(carte.length() - 2);
    }


        public String getCouleur() {
            return this.couleur;
        }

        public int getValeur() {
            return this.valeur;
        }

    }


