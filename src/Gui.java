import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame implements KeyListener{

    private Board myBoard = new Board();
    private JLabel myLabel = new JLabel("Action Shower!", SwingConstants.CENTER);
    private JLabel ResetLabel = new JLabel("Press R to reset!", SwingConstants.CENTER);
    Gui(){
        addKeyListener(this);
        setSize(575,600);
        setTitle("Game | Groep M");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(myLabel, BorderLayout.NORTH);
        add(ResetLabel, BorderLayout.SOUTH);
        add(myBoard, BorderLayout.CENTER);


    }

    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
            myBoard.up();
        }
        if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
            myBoard.down();
        }
        if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
            myBoard.left();
        }
        if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
            myBoard.right();
        }
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
    public static void main(String[] args) {

        Gui go = new Gui();
    }
}

