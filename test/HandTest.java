
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
    List<Card> list5;
    List<Card> list6;
    List<Card> list7;
    List<Card> list8;
    Hand hand1;
    Hand hand2;
    Hand hand3;
    Hand hand4;
    Hand hand5;
    Hand hand6;
    Hand hand7;
    Hand hand8;

    @BeforeEach
    public void setup(){
        list1 = new ArrayList<>(Arrays.asList(new Card("8Tr"),new Card("8Pi"),new Card("8Ca"),new Card("8Co")));
        list2 = new ArrayList<>(Arrays.asList(new Card("4Tr"),new Card("4Pi"),new Card("4Ca"),new Card("7Co")));
        list3 = new ArrayList<>(Arrays.asList(new Card("5Tr"),new Card("9Pi"),new Card("2Ca"),new Card("5Co")));
        list4 = new ArrayList<>(Arrays.asList(new Card("RTr"),new Card("DPi"),new Card("DCa"),new Card("RCo")));
        list5= new ArrayList<>(Arrays.asList(new Card("APi"),new Card("ATr"),new Card("ACa"),new Card("2Tr"), new Card("2Ca")));
        list6= new ArrayList<>(Arrays.asList(new Card("6Pi"),new Card("5Tr"),new Card("4Ca"),new Card("3Tr"),new Card("2Co")));
        list7= new ArrayList<>(Arrays.asList(new Card("APi"),new Card("3Pi"),new Card("7Pi"),new Card("RPi"), new Card("DPi")));
        list8= new ArrayList<>(Arrays.asList(new Card("9Pi"),new Card("8Pi"),new Card("7Pi"),new Card("6Pi"),new Card("5Pi")));


        hand1 = new Hand(list1);
        hand2 = new Hand(list2);
        hand3 = new Hand(list3);
        hand4 = new Hand(list4);
        hand5 = new Hand(list5);
        hand6 = new Hand(list6);
        hand7 = new Hand(list7);
        hand8 = new Hand(list8);

    }

    @Test
    public void testOcc(){
        assertFalse(hand1.pair());
        assertFalse(hand1.brelan());
        assertTrue(hand1.carre());
        assertFalse(hand1.doublePaire());

        assertFalse(hand2.pair());
        assertTrue(hand2.brelan());
        assertFalse(hand2.carre());
        assertFalse(hand2.doublePaire());

        assertTrue(hand4.pair());
        assertFalse(hand4.brelan());
        assertFalse(hand4.carre());
        assertTrue(hand4.doublePaire());

        assertTrue(hand3.pair());
        assertFalse(hand3.brelan());
        assertFalse(hand3.carre());
        assertFalse(hand3.doublePaire());

        assertTrue(hand5.full());
        assertTrue(hand5.pair());
        assertTrue(hand5.brelan());
        assertFalse(hand5.doublePaire());
        assertFalse(hand5.carre());

        assertTrue(hand6.suite());
        assertFalse(hand6.full());
        assertFalse(hand6.pair());
        assertFalse(hand6.brelan());
        assertFalse(hand6.doublePaire());
        assertFalse(hand6.carre());

        assertTrue(hand7.couleur());
        assertFalse(hand7.suite());
        assertFalse(hand7.full());
        assertFalse(hand7.pair());
        assertFalse(hand7.brelan());
        assertFalse(hand7.doublePaire());
        assertFalse(hand7.carre());

        assertTrue(hand8.quinteFlush());
        assertTrue(hand8.couleur());
        assertTrue(hand8.suite());
        assertFalse(hand8.full());
        assertFalse(hand8.pair());
        assertFalse(hand8.brelan());
        assertFalse(hand8.doublePaire());
        assertFalse(hand8.carre());

    }

}