
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



class HandTest {

    List<Card> list1;
    List<Card> list2;
    List<Card> list3;
    List<Card> list4;
    Hand hand1;
    Hand hand2;
    Hand hand3;
    Hand hand4;
    @BeforeEach
    public void setup(){
        list1 = new ArrayList<>();
        list1.add(new Card("8Tr"));
        list1.add(new Card("8Pi"));
        list1.add(new Card("8Ca"));
        list1.add(new Card("8Co"));
        list2 = new ArrayList<>();
        list2.add(new Card("4Tr"));
        list2.add(new Card("4Pi"));
        list2.add(new Card("4Ca"));
        list2.add(new Card("7Co"));
        list3 = new ArrayList<>();
        list3.add(new Card("5Tr"));
        list3.add(new Card("9Pi"));
        list3.add(new Card("2Ca"));
        list3.add(new Card("5Co"));
        list4 = new ArrayList<>();
        list4.add(new Card("RTr"));
        list4.add(new Card("DPi"));
        list4.add(new Card("DCa"));
        list4.add(new Card("RCo"));

        hand1 = new Hand(list1);
        hand2 = new Hand(list2);
        hand3 = new Hand(list3);
        hand4 = new Hand(list4);

    }

    @Test
    public void testOcc(){
        assertFalse(hand1.pair());
        assertFalse(hand1.brelan());
        assertTrue(hand1.carre());
        assertFalse(hand1.doublepPaire());

        assertFalse(hand2.pair());
        assertTrue(hand2.brelan());
        assertFalse(hand2.carre());
        assertFalse(hand2.doublepPaire());

        assertTrue(hand4.pair());
        assertFalse(hand4.brelan());
        assertFalse(hand4.carre());
        assertTrue(hand4.doublepPaire());

        assertTrue(hand3.pair());
        assertFalse(hand3.brelan());
        assertFalse(hand3.carre());
        assertFalse(hand3.doublepPaire());
    }

}