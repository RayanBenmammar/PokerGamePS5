public class Main {

    public static void main(String[] args) {
        int CARD_NUMBER = 5;
        Arbitrator arbitre = new Arbitrator(CARD_NUMBER);
        try{
            arbitre.askHand(0);
            arbitre.askHand(1);
            arbitre.askWinner();
        } catch(PokerException e){
            System.out.println("Erreur : " + e.getMessage());
        } catch(Exception e){
            System.out.println("Oups ! Une erreur inconnue est survenue ! \n");
            System.out.println("Erreur : ");
            e.printStackTrace();
        }
    }
}