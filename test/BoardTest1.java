import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest1 {

    @Test
    public void beweegSpeler() {
        BoardObject speler = new Speler(0,0);
        int Xpos = speler.getPosition().x;
        assertEquals(0,Xpos);


    }
}