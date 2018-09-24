import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Card> list1 = new ArrayList<>();
        List<Card> list2 = new ArrayList<>();

        System.out.println("Veuillez entrer la main1, avec la bonne forme : ");
        for(int i = 0; i<3; i++){
            String str = sc.next();
            list1.add(new Card(str));

        }
        Hand hand1 = new Hand(list1);


        sc.nextLine();

        System.out.println("Veuillez entrer la main2, avec la bonne forme : ");
        for(int i = 0; i<3; i++) {
            String str2 = sc.next();
            list2.add(new Card(str2));
        }
        Hand hand2 = new Hand(list2);





        hand1.checkCombinaison();
        hand2.checkCombinaison();
        if(hand2.isWeakerThan(hand1)){
            System.out.println("La main 1 gagne avec : " + hand1.getBestCombi() + " de " + hand1.getBestCombi().getCombiCard().getValue());
        } else if (hand2.hasSameCombination(hand1)) {
            // Mettre code pour faire la hauteur de la combinaison
            hand1.high();
            hand2.high();
            if (Integer.parseInt(hand1.getBestCombinationValue().getVal()) > Integer.parseInt(hand2.getBestCombinationValue().getVal())) {
                System.out.println("La main 1 gagne avec : " + hand1.getBestCombi().getVal() + " de " + hand1.getBestCombinationValue());
            } else if (Integer.parseInt(hand1.getBestCombinationValue().getVal()) == Integer.parseInt(hand2.getBestCombinationValue().getVal())) {
                System.out.println("Egalité ! ");
            }
            else {
                System.out.println("La main 2 gagne avec : " + hand2.getBestCombi().getVal() + " de " + hand2.getBestCombinationValue());
            }

        } else {
            System.out.println("La main 2 gagne avec : " + hand2.getBestCombi() + " de " + hand2.getBestCombi().getCombiCard().getValue());
        }



    }
}