
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



class ArbitratorTest {


    List<Card> list1;
    List<Card> list2;
    List<Card> list3;
    List<Card> list4;
    List<Card> list5;
    List<Card> list6;
    Hand hand1;
    Hand hand2;
    Hand hand3;
    Hand hand4;
    Hand hand5;
    Hand hand6;

    @BeforeEach
    public void setup() {
        list1 = new ArrayList<>(Arrays.asList(new Card("8Pi"),new Card("8Tr"),new Card("7Ca"),new Card("ATr")));
        list2 = new ArrayList<>(Arrays.asList(new Card("2Pi"),new Card("4Tr"),new Card("RCa"),new Card("5Tr")));
        list3 = new ArrayList<>(Arrays.asList(new Card("6Pi"),new Card("6Tr"),new Card("6Ca"),new Card("ATr")));
        list4 = new ArrayList<>(Arrays.asList(new Card("3Pi"),new Card("3Tr"),new Card("DCa"),new Card("DTr")));
        list5= new ArrayList<>(Arrays.asList(new Card("APi"),new Card("7Tr"),new Card("VCa"),new Card("2Tr")));
        list6= new ArrayList<>(Arrays.asList(new Card("APi"),new Card("7Tr"),new Card("VCa"),new Card("2Tr")));

        hand1 = new Hand(list1);
        hand2 = new Hand(list2);
        hand3 = new Hand(list3);
        hand4 = new Hand(list4);
        hand5 = new Hand(list5);
        hand6 = new Hand(list6);

    }

    @Test
    public void testWin() throws PokerException{
        assertFalse(hand1.isWeakerThan(hand2));
        assertFalse(hand3.isWeakerThan(hand4));
        assertFalse(hand3.isWeakerThan(hand4));



    }

}
