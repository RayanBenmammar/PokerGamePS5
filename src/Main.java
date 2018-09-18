import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("veuillez entrer la main1, avec la bonne forme : ");
        String str = sc.next();
        System.out.println("vous avez saisi la carte : " + str);
        Card c1 = new Card(str);

        sc.nextLine();

        System.out.println("veuillez entrer la main1, avec la bonne forme : ");
        String str2 = sc.next();
        System.out.println("vous avez saisi la carte : " + str2);
        Card c2 = new Card(str2);


        if(c2.isWeakerThan(c1)){
            System.out.println("La carte gagnante est : " + c1.getValue() + " de " + c1.getColor());
        } else if (c2.equals(c1)) {
            System.out.println("Egalité !");
        } else {
            System.out.println("La carte gagnante est : " + c2.getValue() + " de " + c2.getColor());
        }

    }
}