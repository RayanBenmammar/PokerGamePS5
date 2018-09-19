import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer la main1, avec la bonne forme : ");
        String str = sc.next();
        List<Card> list1 = new ArrayList<>();
        list1.add(new Card(str));
        Hand hand1 = new Hand(list1);

        sc.nextLine();

        System.out.println("Veuillez entrer la main2, avec la bonne forme : ");
        String str2 = sc.next();
        List<Card> list2 = new ArrayList<>();
        list2.add(new Card(str2));
        Hand hand2 = new Hand(list2);

        if(hand2.isWeakerThan(hand1)){
            System.out.println("La main 1 gagne avec la carte : " + hand1.hand.get(0).getValue() + " de " + hand1.hand.get(0).getColor());
        } else if (hand2.equals(hand1)) {
            System.out.println("Egalité !");
        } else {
            System.out.println("La main 2 gagne avec la carte : " + hand2.hand.get(0).getValue() + " de " + hand2.hand.get(0).getColor());
        }

    }
}