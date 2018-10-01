public class Arbitrator {
    private Hand[] hands;
    private CardReader reader;
    public int cardNumber;

    Arbitrator(int cardNumber_){
        reader = new CardReader();
        hands = new Hand[2];
        cardNumber = cardNumber_;
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void askHand(int index){
        this.printMessage("Veuillez entrer la main1, avec la bonne forme : ");
        if(index < 2 && index >= 0) {
            hands[index] = new Hand(reader.readCardFromInput(cardNumber));
        }
    }

    public void askWinner() {
        hands[0].checkCombinaison();
        hands[1].checkCombinaison();
        if (hands[1].isWeakerThan(hands[0])) {
            this.printMessage("La main 1 gagne avec : " + hands[0].getBestCombi() + " de " + hands[0].getCombiCard().getValue());
        } else {
            this.printMessage("La main 2 gagne avec : " + hands[0].getBestCombi() + " de " + hands[0].getCombiCard().getValue());
        }

        // Mettre le code de la hauteur dans la méthode isWeakerThan, cette méthode doit juste renvoyer vrai ou faux, et on affiche qui gagne en fonction.
        /*else if (hands[1].hasSameCombination(hands[0])) {
            // Mettre code pour faire la hauteur de la combinaison
            hands[0].high();
            hands[1].high();

            // Si combinaison de main2 plus faible que combinaison de main1 ===> main1 gagne
            if (hands[1].getCombiCard().isWeakerThan(hands[0].getCombiCard())) {
                System.out.println("La main 1 gagne avec : " + hands[0].getBestCombi() + " de " + hands[0].getCombiCard().getValue());

            // Sinon si combinaison de main1 égal combinaison de main2 ===> égalité (pas forcément vrai)
            } else if (hands[0].getCombiCard().equals(hands[1].getCombiCard())) {

                System.out.println("Egalité ! ");
            }

            // Sinon main2 gagne
            else {
                System.out.println("La main 2 gagne avec : " + hands[1].getBestCombi() + " de " + hands[1].getCombiCard().getValue());
            }

        }*/
    }

}
