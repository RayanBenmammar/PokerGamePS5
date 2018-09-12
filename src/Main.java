public class Main {

    public static void main(String[] args) {
        Carte c1 = new Carte("8Pi");
        Carte c2 = new Carte("10Pi");

        if(c2.isWeakerThan(c1)){
            System.out.println("La carte gagnante est : " + c1.getValeur());
        } else {
            System.out.println("La carte gagnante est : " + c2.getValeur());
        }

    }
}