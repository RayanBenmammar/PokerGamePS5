public class Main {

    public static void main(String[] args) {
        Carte c1 = new Carte("8Ca");
        Carte c2 = new Carte("5Pi");

        if(c2.isWeakerThan(c1)){
            System.out.println("La carte gagnante est : " + c1.getValeur() + " de " + c1.getCouleur());
        } else if (c2.equals(c1)) {
            System.out.println("Egalité !");
        } else {
            System.out.println("La carte gagnante est : " + c2.getValeur() + " de " + c2.getCouleur());
        }

    }
}