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

        setTitle("Game | Groep M");

        setSize(500,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        myBoard.updateHomePanel();


        super.add(myBoard);

        super.setVisible(true);
    }

    @Override

    public void keyPressed(KeyEvent e){

        int keyCode = e.getKeyCode();

        switch (keyCode){

            case KeyEvent.VK_W: case KeyEvent.VK_UP:

                myBoard.beweegSpeler('x',-1);
                break;

            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:

                myBoard.beweegSpeler('x', 1);
                break;

            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:

                myBoard.beweegSpeler('y', -1);
                break;

            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:

                myBoard.beweegSpeler('y', 1);
                break;

            case KeyEvent.VK_ESCAPE:

                System.exit(0);
                break;

            case KeyEvent.VK_R:

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
        Gui go = new Gui();

        go.addKeyListener(go);
    }
}

