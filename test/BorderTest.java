import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

// Gemaakt door: John
// Hier test ik dat de speler niet van het veld af mag lopen.

public class BorderTest extends JFrame {
    Board myBoard = new Board();
    @Test
    public void BorderTest() throws Exception {
        myBoard.startLevel(0);
        Thread.sleep(1000);

        setTitle("Game | Collision Test");

        setSize(500,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myBoard.updateHomePanel();

        super.add(myBoard);

        super.setVisible(true);

        for (int i = 0; i < 15; i++){
                myBoard.beweegSpeler('x',1);
            Thread.sleep(1000);
        }

        Thread.sleep(1000);

        assertEquals(9, myBoard.speler.getPosition().y);


    }
}