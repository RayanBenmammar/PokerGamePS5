public class Main {

    public static void main(String[] args) {

        CardReader reader = new CardReader();

        System.out.println("Veuillez entrer la main1, avec la bonne forme : ");
        Hand hand1 = new Hand(reader.readCardFromInput(3));

        System.out.println("Veuillez entrer la main2, avec la bonne forme : ");
        Hand hand2 = new Hand(reader.readCardFromInput(3));





        hand1.checkCombinaison();
        hand2.checkCombinaison();
        if(hand2.isWeakerThan(hand1)){
            System.out.println("La main 1 gagne avec : " + hand1.getBestCombi() + " de " + hand1.getCombiCard().getValue());
        } else if (hand2.hasSameCombination(hand1)) {
            // Mettre code pour faire la hauteur de la combinaison
            hand1.high();
            hand2.high();
            if (hand2.getCombiCard().isWeakerThan(hand1.getCombiCard())) {
                System.out.println("La main 1 gagne avec : " + hand1.getBestCombi() + " de " + hand1.getCombiCard().getValue());
            } else if (hand1.getCombiCard().equals(hand2.getCombiCard())) {

                System.out.println("Egalité ! ");
            }
            else {
                System.out.println("La main 2 gagne avec : " + hand2.getBestCombi() + " de " + hand2.getCombiCard().getValue());
            }

        } else {
            System.out.println("La main 2 gagne avec : " + hand2.getBestCombi() + " de " + hand2.getCombiCard().getValue());
        }

    }
}