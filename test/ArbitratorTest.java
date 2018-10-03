
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ArbitratorTest {

    List<Card> list1;
    List<Card> list2;
    List<Card> list3;
    List<Card> list4;
    Hand hand1;
    Hand hand2;
    Hand hand3;
    Hand hand4;
    @BeforeEach
    public void setup() {
        list1 = new ArrayList<>();
        list1.add(new Card("8Tr"));
        list1.add(new Card("8Pi"));
        list1.add(new Card("4Ca"));
        list1.add(new Card("9Co"));
        list2 = new ArrayList<>();
        list2.add(new Card("4Tr"));
        list2.add(new Card("7Pi"));
        list2.add(new Card("9Ca"));
        list2.add(new Card("ACo"));
        list3 = new ArrayList<>();
        list3.add(new Card("5Tr"));
        list3.add(new Card("5Pi"));
        list3.add(new Card("5Ca"));
        list3.add(new Card("7Co"));
        list4 = new ArrayList<>();
        list4.add(new Card("RTr"));
        list4.add(new Card("RPi"));
        list4.add(new Card("9Ca"));
        list4.add(new Card("9Co"));

        hand1 = new Hand(list1);
        hand2 = new Hand(list2);
        hand3 = new Hand(list3);
        hand4 = new Hand(list4);

    }

    @Test
    public void testWin(){
        assertFalse(hand1.getCombiCard().isWeakerThan(hand2.getCombiCard()));
        assertFalse(hand3.getCombiCard().isWeakerThan(hand4.getCombiCard()));



    }

}
