public class Arbitrator {
    private Hand[] hands;
    private HandReader reader;
    public int cardNumber;

    Arbitrator(int cardNumber_){
        reader = new HandReader();
        hands = new Hand[2];
        cardNumber = cardNumber_;
    }

    public void askHand(int index) throws PokerException {
        if(index < hands.length && index >= 0) {
            hands[index] = reader.readCardsFromInput(cardNumber, index);
        } else {
            throw new PokerException("Vous avez demander la main " + index + ", alors qu'elle n'existe pas.");
        }
        if(!hands[index].areCardsValid()){
            throw new PokerException("Veuillez rentrer correctement les mains.");
        }
    }

    public void askWinner() throws PokerException{
        int indexWinningHand = reader.checkWinner(hands[0], hands[1]);
        System.out.println("La main " + (indexWinningHand+1) + " gagne avec : " + hands[indexWinningHand].getBestCombi() + " de " + hands[indexWinningHand].getCombiCard().getValue());
    }
}
