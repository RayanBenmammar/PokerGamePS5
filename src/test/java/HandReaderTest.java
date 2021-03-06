import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandReaderTest {

    List<Card> list1;
    List<Card> list2;
    List<Card> list3;
    List<Card> list4;
    List<Card> list5;
    List<Card> list6;
    List<Card> list7;
    List<Card> list8;
    List<Card> list9;
    List<Card> list10;
    List<Card> list11;
    Hand hand1;
    Hand hand2;
    Hand hand3;
    Hand hand4;
    Hand hand5;
    Hand hand6;
    Hand hand7;
    Hand hand8;
    Hand hand9;
    Hand hand10;
    Hand hand11;

    @BeforeEach
    public void setup(){
        list1 = new ArrayList<>(Arrays.asList(new Card("2Tr"),new Card("4i"),new Card("6Ca"),new Card("ACo"),new Card("9Co")));
        list2 = new ArrayList<>(Arrays.asList(new Card("4Tr"),new Card("4Pi"),new Card("2Ca"),new Card("7Co"),new Card("RCo")));
        list3 = new ArrayList<>(Arrays.asList(new Card("5Tr"),new Card("5Pi"),new Card("2Ca"),new Card("2Co"),new Card("9Co")));
        list4 = new ArrayList<>(Arrays.asList(new Card("RTr"),new Card("RPi"),new Card("RCa"),new Card("2Co"),new Card("9Co")));
        list5= new ArrayList<>(Arrays.asList(new Card("9Pi"),new Card("8Tr"),new Card("7Ca"),new Card("6Tr"), new Card("5Ca")));
        list6= new ArrayList<>(Arrays.asList(new Card("6Pi"),new Card("5Pi"),new Card("9Pi"),new Card("2Pi"),new Card("RPi")));
        list7= new ArrayList<>(Arrays.asList(new Card("APi"),new Card("ATr"),new Card("ACo"),new Card("2Pi"), new Card("2Tr")));
        list8= new ArrayList<>(Arrays.asList(new Card("9Pi"),new Card("9Co"),new Card("9Ca"),new Card("9Tr"),new Card("5Pi")));
        list9= new ArrayList<>(Arrays.asList(new Card("9Pi"),new Card("8Pi"),new Card("7Pi"),new Card("6Pi"),new Card("5Pi")));
        list10= new ArrayList<>(Arrays.asList(new Card("2Pi"),new Card("8Co"),new Card("RPi"),new Card("6Pi"),new Card("5Pi")));
        list11= new ArrayList<>(Arrays.asList(new Card("9Pi"),new Card("9Ca"),new Card("DCo"),new Card("6Pi"),new Card("5Pi")));


        hand1 = new Hand(list1);
        hand2 = new Hand(list2);
        hand3 = new Hand(list3);
        hand4 = new Hand(list4);
        hand5 = new Hand(list5);
        hand6 = new Hand(list6);
        hand7 = new Hand(list7);
        hand8 = new Hand(list8);
        hand9= new Hand(list9);
        hand10= new Hand(list10);
        hand11= new Hand(list11);

    }

    @Test
    public void testCheckWinner() throws PokerException{
        HandReader reader = new HandReader();
        assertEquals(1, reader.checkWinner(hand1, hand2));
        assertEquals(1, reader.checkWinner(hand1, hand3));
        assertEquals(1, reader.checkWinner(hand1, hand4));
        assertEquals(1, reader.checkWinner(hand1, hand5));
        assertEquals(1, reader.checkWinner(hand1, hand6));
        assertEquals(1, reader.checkWinner(hand1, hand7));
        assertEquals(1, reader.checkWinner(hand1, hand8));
        assertEquals(1, reader.checkWinner(hand1, hand9));

        assertEquals(1, reader.checkWinner(hand2, hand3));
        assertEquals(1, reader.checkWinner(hand2, hand4));
        assertEquals(1, reader.checkWinner(hand2, hand5));
        assertEquals(1, reader.checkWinner(hand2, hand6));
        assertEquals(1,reader.checkWinner(hand2, hand7));
        assertEquals(1, reader.checkWinner(hand2, hand8));
        assertEquals(1, reader.checkWinner(hand2, hand9));

        assertEquals(1, reader.checkWinner(hand3, hand4));
        assertEquals(1, reader.checkWinner(hand3, hand5));
        assertEquals(1, reader.checkWinner(hand3, hand6));
        assertEquals(1, reader.checkWinner(hand3, hand7));
        assertEquals(1, reader.checkWinner(hand3, hand8));
        assertEquals(1, reader.checkWinner(hand3, hand9));

        assertEquals(1, reader.checkWinner(hand4, hand5));
        assertEquals(1, reader.checkWinner(hand4, hand6));
        assertEquals(1, reader.checkWinner(hand4, hand7));
        assertEquals(1, reader.checkWinner(hand4, hand8));
        assertEquals(1, reader.checkWinner(hand4, hand9));

        assertEquals(1, reader.checkWinner(hand5, hand6));
        assertEquals(1, reader.checkWinner(hand5, hand7));
        assertEquals(1, reader.checkWinner(hand5, hand8));
        assertEquals(1, reader.checkWinner(hand5, hand9));

        assertEquals(1, reader.checkWinner(hand6, hand7));
        assertEquals(1, reader.checkWinner(hand6, hand8));
        assertEquals(1, reader.checkWinner(hand6, hand9));

        assertEquals(1, reader.checkWinner(hand7, hand8));
        assertEquals(1, reader.checkWinner(hand7, hand9));

        assertEquals(1, reader.checkWinner(hand8, hand9));


        assertEquals(0, reader.checkWinner(hand2, hand1));
        assertEquals(0, reader.checkWinner(hand5, hand3));
        assertEquals(0, reader.checkWinner(hand8, hand4));
        assertEquals(0, reader.checkWinner(hand9, hand8));
        assertEquals(0, reader.checkWinner(hand7, hand2));

        assertEquals(-1, reader.checkWinner(hand7, hand7));
        assertEquals(-1, reader.checkWinner(hand3, hand3));
        assertEquals(-1, reader.checkWinner(hand5, hand5));
        assertEquals(0,reader.checkWinner(hand1,hand10));
        assertEquals(0,reader.checkWinner(hand11,hand2));

    }
}