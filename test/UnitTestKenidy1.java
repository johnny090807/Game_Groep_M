import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;
//Gemaakt door: Kenidy Salvador
//De speler kan barricades verwijderen met een passende sleutel.

public class UnitTestKenidy1 {

    @Test
    public void getSleutel() {

        Speler speler = new Speler(0, 0);
        BoardObject barricade = new Barricade(1, 1, 100);
        BoardObject sleutel = new Sleutel(2, 1, 100);



        speler.setSleutel((Sleutel) sleutel);
        boolean result = ((Barricade) barricade).unlockValue == speler.getSleutel().getValue();


        assertEquals("juist sleutel", true, result);

     }

    }

