import javax.swing.*;
import java.awt.*;

public class BoardObject {

    private JLabel label;

    private Point position;

    private Type type;

    public enum Type{
        BARRICADE,
        MUUR,
        SLEUTEL,
        EINDE
    }
    public BoardObject(int x, int y){
        this.position = new Point(x,y);
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setPosition(int x, int y){
        this.position = new Point(x,y);
    }

    public Type getType(){
        return this.type;
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
