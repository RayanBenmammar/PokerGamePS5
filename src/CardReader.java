import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CardReader {
    CardReader(){

    }



    public List<Card> readCardFromInput(int cardNumber){
        Scanner sc = new Scanner(System.in);
        List<Card> list = new ArrayList<>();

        for(int i = 0; i<cardNumber; i++){
            String str = sc.next();
            list.add(new Card(str));
        }
        return list;
    }
}
