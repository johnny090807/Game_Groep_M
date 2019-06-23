import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;
//Gemaakt door : Kenidy Salvador
//Als de speler een sleutel op een barricade probeert en de sleutel niet past, dan komt een pop-up melding.


public class UnitTestKenidy2 {

    @Test
    public void beweegSpeler() {

        Speler speler = new Speler(0, 0);
        BoardObject barricade = new Barricade(0, 1, 200);
        BoardObject sleutel = new Sleutel(0, 2, 100);

     speler.setSleutel((Sleutel) sleutel);

       boolean result;
                if(((Barricade) barricade).unlockValue != speler.getSleutel().getValue()) {

                    result = true;
                    JOptionPane.showMessageDialog(null, "Hier heb je sleutel " + barricade.getValue() + " nodig ");


                }else {

                    result = false;
                }


        assertEquals("",true,result);


     }
    }
