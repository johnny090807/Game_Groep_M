import org.junit.Test;

import javax.swing.*;
import java.util.Scanner;

import static org.junit.Assert.*;

        //  Mhamed Arkoubi
        //  Unit test requirement:  2) De speler staat steeds op één van die vakjes en kan naar aanliggende vakjes bewegen.
public class TestBeweegSpeler extends JFrame  {
    Board myBoard = new Board();




    @Test
    public void beweegSpeler() {
        myBoard.startLevel(0);


        myBoard.speler = new Speler(2,8);

        myBoard.beweegSpeler('x', 1);

        myBoard.beweegSpeler('y',-1);


        assertEquals(3,myBoard.speler.getPosition().x);

        assertEquals(7,myBoard.speler.getPosition().y);

    }
}