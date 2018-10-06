
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;




public class CardTest {

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card6;


    @BeforeEach
    public void setup(){
        card1=new Card("9Pi");
        card2=new Card("RTr");
        card3= new Card("10Co");
        card4=new Card("9Ca");
        card5=new Card("ATr");
        card6=new Card("2Co");

    }

    @Test
    public void testCardWin(){
        assertTrue(card1.isWeakerThan(card3));
        assertFalse(card2.isWeakerThan(card6));
        assertTrue(card4.isWeakerThan(card5));
        assertFalse(card3.isWeakerThan(card1));
        assertTrue(card1.equals(card4));
        assertFalse(card2.equals(card6));
    }



    @Test
    public void testSameColor(){
        assertTrue(card3.isSameColor(card6));
        assertFalse(card1.isSameColor(card2));
        assertTrue(card2.isSameColor(card5));
        assertFalse(card4.isSameColor(card3));
    }
}
