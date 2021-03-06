import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Type;

public abstract class BoardObject {

    private JLabel label;

    private Point position;

    public abstract int getValue();
    public abstract void checkCollision(Speler speler, Square vorigeSquare, Square volgendeSquare, Board board);

    public BoardObject(int x, int y){
        this.position = new Point(x,y);
    }

    public void setPosition(int x, int y){
        this.position = new Point(x,y);
    }

    public Point getPosition(){
        return this.position;
    }

    public JLabel getLabel(){
         return this.label;
    }

    public void setLabel(JLabel label){
        this.label = label;
    }
}
