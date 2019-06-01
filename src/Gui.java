import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame implements KeyListener{

    private Board myBoard = new Board();
    Gui(){
        setTitle("Game | Groep M");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(myBoard);

        setVisible(true);
    }

    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_W: case KeyEvent.VK_UP:
                myBoard.up();
                break;
            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
                myBoard.down();
                break;
            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
                myBoard.left();
                break;
            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
                myBoard.right();
                break;
        }
    }

    public void keyTyped(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
    public static void main(String[] args) {
        Gui go = new Gui();
        go.addKeyListener(go);

    }
}

