import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*
    Klasse GUI;
    Het overerft de klasse JFrame
    en het implement de KeyListener voor de inputs.

 */
public class Gui extends JFrame implements KeyListener{
    // Hierin word het speelboard opgeslagen
    Board myBoard = new Board();
    // Constructor voor deze klasse
    Gui(){
        // Zet de titel van de JFrame
        setTitle("Game | Groep M");
        // Zet de grootte van de JFame
        setSize(500,600);
        // Hetgeen wat gebeurd zodra het venster gesloten wordt
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Update het home paneel van het board
        myBoard.updateHomePanel();

        // Voeg het board toe aan de JFrame
        super.add(myBoard);
        // Maak het frame zichtbaar
        super.setVisible(true);
    }

    @Override
    // Wanneer een knop wordt ingedrukt kijkt hij naar deze methode
    public void keyPressed(KeyEvent e){
        // Zet de keycode vast voor de Switch Case
        int keyCode = e.getKeyCode();
        // Start de switchcase zodat hij weet wat het moet doen met de input
        switch (keyCode){
            // Mocht W of Pijl omhoog ingedrukt worden dan gebeurt het volgende
            case KeyEvent.VK_W: case KeyEvent.VK_UP:
                // Beweeg de speler in de gestelde richting
                myBoard.beweegSpeler('x',-1);
                break;
            // Mocht S of Pijl omlaag ingedrukt worden dan gebeurt het volgende
            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
                // Beweeg de speler in de gestelde richting
                myBoard.beweegSpeler('x', 1);
                break;
            // Mocht A of Pijl naar links ingedrukt worden dan gebeurt het volgende
            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
                // Beweeg de speler in de gestelde richting
                myBoard.beweegSpeler('y', -1);
                break;
            // Mocht D of Pijl naar rechts ingedrukt worden dan gebeurt het volgende
            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
                // Beweeg de speler in de gestelde richting
                myBoard.beweegSpeler('y', 1);
                break;
            // Mocht escape ingedrukt worden dan gebeurt het volgende
            case KeyEvent.VK_ESCAPE:
                // Sluit de game
                System.exit(0);
                break;
            // Mocht R ingedrukt worden dan gebeurt het volgende
            case KeyEvent.VK_R:
                // Restart het level
                myBoard.restartLevel();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyReleased(KeyEvent e){

    }
    public static void main(String[] args) {
        // initializeer het GUI
        Gui go = new Gui();
        // Voeg de keylistener toe aan de GUI
        go.addKeyListener(go);
    }
}

