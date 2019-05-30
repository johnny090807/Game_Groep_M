import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {
    private int startX = 60;
    private int startY = 60;

    public void left(){
        if(startX > 60){
            startX -= 50;
        }
        this.repaint();
    }
    public void right(){
        if(startX < 440){
            startX += 50;
        }
        this.repaint();
    }
    public void up(){
        if(startY > 60){
            startY -= 50;
        }
        this.repaint();
    }
    public void down(){
        if(startY < 440){
            startY += 50;
        }
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        for (int x = 1; x < 10; x++){
            for(int y = 1; y < 10; y++){
                g.drawRect(50 * x, 50 * y, 50,50);
            }
        }
        g.drawOval(startX, startY, 30, 30);
    }
}
