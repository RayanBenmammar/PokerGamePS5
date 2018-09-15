import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("veuillez entrer la main1, avec la bonne forme : ");
        String str = sc.next();
        System.out.println("vous avez saisi la carte : " + str);
        Carte c1 = new Carte(str);

        sc.nextLine();

        System.out.println("veuillez entrer la main1, avec la bonne forme : ");
        String str2 = sc.next();
        System.out.println("vous avez saisi la carte : " + str2);
        Carte c2 = new Carte(str2);


        if(c2.isWeakerThan(c1)){
            System.out.println("La carte gagnante est : " + c1.getValeur() + " de " + c1.getCouleur());
        } else if (c2.equals(c1)) {
            System.out.println("Egalité !");
        } else {
            System.out.println("La carte gagnante est : " + c2.getValeur() + " de " + c2.getCouleur());
        }

    }
}