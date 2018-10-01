public class Main {

    public static void main(String[] args) {
        Arbitrator arbitre = new Arbitrator(3);
        arbitre.askHand(0);
        arbitre.askHand(1);
        arbitre.askWinner();
    }
}