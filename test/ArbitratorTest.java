
import static org.junit.jupiter.api.Assertions.*;


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
        list1 = new ArrayList<>(Arrays.asList(new Card("2Tr"),new Card("4i"),new Card("6Ca"),new Card("ACo"),new Card("9Co")));
        list2 = new ArrayList<>(Arrays.asList(new Card("4Tr"),new Card("4Pi"),new Card("2Ca"),new Card("7Co"),new Card("RCo")));
        list3 = new ArrayList<>(Arrays.asList(new Card("5Tr"),new Card("5Pi"),new Card("2Ca"),new Card("2Co"),new Card("9Co")));
        list4 = new ArrayList<>(Arrays.asList(new Card("RTr"),new Card("RPi"),new Card("RCa"),new Card("2Co"),new Card("9Co")));
        list5= new ArrayList<>(Arrays.asList(new Card("9Pi"),new Card("8Tr"),new Card("7Ca"),new Card("6Tr"), new Card("2Ca")));
        list6= new ArrayList<>(Arrays.asList(new Card("6Pi"),new Card("5Pi"),new Card("9Pi"),new Card("2Pi"),new Card("RPi")));
        list7= new ArrayList<>(Arrays.asList(new Card("APi"),new Card("ATr"),new Card("ACo"),new Card("2Pi"), new Card("2Tr")));
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
    public void testWin() throws PokerException{
        assertFalse(hand4.isWeakerThan(hand3));
        assertFalse(hand2.isWeakerThan(hand1));
        assertFalse(hand3.isWeakerThan(hand1));
        assertFalse(hand6.isWeakerThan(hand2));
        assertFalse(hand5.isWeakerThan(hand3));




    }

}
