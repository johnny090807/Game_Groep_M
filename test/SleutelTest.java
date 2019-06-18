import org.junit.Test;

import static org.junit.Assert.*;

public class SleutelTest {

    @Test
    public void getSleutel() {

        BoardObject speler = new Speler(0,0);
        BoardObject sleutel = new Sleutel(1,1,100);

        int expectedResult = 100;
        int result = speler.getSleutel().getValue();

        assertEquals("juist sleutel",expectedResult,result);
    }
}