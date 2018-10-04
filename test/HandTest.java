
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        list1 = new ArrayList<>(Arrays.asList(new Card("8Tr"),new Card("8Pi"),new Card("8Ca"),new Card("8Co")));
        list2 = new ArrayList<>(Arrays.asList(new Card("4Tr"),new Card("4Pi"),new Card("4Ca"),new Card("7Co")));
        list3 = new ArrayList<>(Arrays.asList(new Card("5Tr"),new Card("9Pi"),new Card("2Ca"),new Card("5Co")));
        list4 = new ArrayList<>(Arrays.asList(new Card("RTr"),new Card("DPi"),new Card("DCa"),new Card("RCo")));


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