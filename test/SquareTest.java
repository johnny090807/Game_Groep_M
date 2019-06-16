import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class SquareTest {

    @Test
    public void hasBoardObject() {
        BoardObject barricade = new Barricade(2,2, 200);
        int unlockValue = barricade.getValue();
        assertEquals(200,unlockValue);

    }
}