import javax.swing.*;
import java.awt.*;

public class BoardObject extends JComponent {
    private int x;
    private int y;

    private Type type = Type.SPELER;

    private enum Type{
        SPELER,
        BARRICADE,
        MUUR,
        SLEUTEL
    }
    public BoardObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public BoardObject(int x, int y, Type type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setType(Type type){
        this.type = type;
    }

    public Type getType(){
        return this.type;
    }

    @Override
    public void paintComponent(Graphics g){
        switch (type){
            case MUUR:

                break;
            case SPELER:
                g.drawOval(60,60,40,40);
                break;
            case SLEUTEL:
                break;
            case BARRICADE:
                break;
        }
    }
}
