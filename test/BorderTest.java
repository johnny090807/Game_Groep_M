import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

// Gemaakt door: John Klees
// Deze test kijkt of de speler van het veld af kan lopen.

public class BorderTest extends JFrame {
    Board myBoard = new Board();
    @Test
    public void BorderTestY() throws Exception {
        Thread.sleep(1000);

        myBoard.startLevel(0);

        setTitle("Game | Collision Test");

        setSize(500,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myBoard.updateHomePanel();

        super.add(myBoard);

        super.setVisible(true);

        for (int i = 0; i < 15; i++){
            myBoard.beweegSpeler('y', 1);
            Thread.sleep(1000);
        }

        Thread.sleep(1000);

        assertEquals(9, myBoard.speler.getPosition().y);


    }
    @Test
    public void BorderTestX() throws Exception {
        myBoard.startLevel(0);
        Thread.sleep(1000);

        setTitle("Game | Collision Test");

        setSize(500,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myBoard.updateHomePanel();

        super.add(myBoard);

        super.setVisible(true);

        for (int i = 0; i < 15; i++){
            myBoard.beweegSpeler('x', 1);
            Thread.sleep(1000);
        }

        Thread.sleep(1000);

        assertEquals(9, myBoard.speler.getPosition().x);


    }
}