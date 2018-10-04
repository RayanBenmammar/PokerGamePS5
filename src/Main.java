public class Main {

    public static void main(String[] args) {
        Arbitrator arbitre = new Arbitrator(4);
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