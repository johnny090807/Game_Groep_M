import org.junit.Test;

import static org.junit.Assert.*;


public class BoardObjectTest {
//Mhamed Arkoubi
//       Unit teste  requirement:  6)De Sleutels liggen op de vakjes van het speelveld.

    @Test

    public void getPositionX() {

        Sleutel sleutel = new Sleutel(2, 3, 100);
        int xPos = sleutel.getPosition().x;
        assertEquals(2, xPos);

    }

    @Test
    public void getPositionY() {
        Sleutel sleutel = new Sleutel(2, 3, 100);
        int yPos = sleutel.getPosition().y;
        assertEquals(3, yPos);

    }

    @Test
    public void getValue() {
        Sleutel sleutel = new Sleutel(2, 3, 100);
        int value = sleutel.getValue();
        assertEquals(100, value);

    }
}
